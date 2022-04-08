package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.houses = new ArrayList<>();
        toys = new ToyRepository();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Mouse":
                toy = new Mouse();
                break;
            case "Ball":
                toy = new Ball();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        for (House h : houses) {
            if (h.getName().equals(houseName)) {
                h.buyToy(toy);
                break;
            }
        }

        this.toys.removeToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        House house = null;
        for (House h : houses) {
            if (h.getName().equals(houseName)) {
                house = h;
                break;
            }
        }

        String houseType = house.getClass().getSimpleName();

        if (catType.equals("ShorthairCat") && houseType.equals("ShortHouse")
                || catType.equals("LonghairCat") && houseType.equals("LongHouse")) {
            house.addCat(cat);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }
    }

    @Override
    public String feedingCat(String houseName) {
        List<House> houses = this.houses
                .stream()
                .filter(house -> house.getName().equals(houseName))
                .limit(1)
                .collect(Collectors.toList());

        House house = houses.get(0);
        house.feeding();

        return String.format(ConstantMessages.FEEDING_CAT,house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        List<House> houses = this.houses
                .stream()
                .filter(house -> house.getName().equals(houseName))
                .limit(1)
                .collect(Collectors.toList());

        House house = houses.get(0);
        double catsPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toysPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();

        double allPrice = catsPrice + toysPrice;

        return String.format(ConstantMessages.VALUE_HOUSE,houseName,allPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder stats = new StringBuilder();

        for (House house :houses) {
            stats.append(house.getStatistics()).append("\n");
        }

        return stats.toString().trim();
    }
}
