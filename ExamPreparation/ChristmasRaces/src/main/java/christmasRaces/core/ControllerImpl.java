package christmasRaces.core;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;

import christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
        }
        Driver newDriver = new DriverImpl(driver);
        driverRepository.add(newDriver);
        return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }
        carRepository.add(car);
        StringBuilder stringBuilder = new StringBuilder();
        if (type.equals("Muscle")) {
            stringBuilder.append("MuscleCar ").append(model).append(" is created.");
        } else if (type.equals("Sports")) {
            stringBuilder.append("SportsCar ").append(model).append(" is created.");
        }
        return stringBuilder.toString();
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Car car = carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);

        if (race == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }

        if (race.getDrivers().size() < 3){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID,raceName,3));
        }

        int laps = race.getLaps();
        List<Driver> threeFastestDrivers = race.getDrivers()
                .stream()
                .sorted((d2,d1) -> Double.compare(d1.getCar().calculateRacePoints(laps),d2.getCar().calculateRacePoints(laps)))
                .limit(3)
                .collect(Collectors.toList());

        this.raceRepository.remove(race);

        Driver first = threeFastestDrivers.get(0);
        Driver second = threeFastestDrivers.get(1);
        Driver third = threeFastestDrivers.get(2);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(OutputMessages.DRIVER_FIRST_POSITION,first.getName(),raceName)).append("\n");
        stringBuilder.append(String.format(OutputMessages.DRIVER_SECOND_POSITION,second.getName(),raceName)).append("\n");
        stringBuilder.append(String.format(OutputMessages.DRIVER_THIRD_POSITION,third.getName(),raceName)).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        if (raceRepository.getByName(name) != null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS,name));
        }
        raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED,name);
    }
}
