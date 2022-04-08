package garage;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {

    @Test
    public void testMethodGetCountOfCarsAndAddCars(){
        Garage garage = new Garage();
        Car bmw = new Car("BMW",150,3700);
        Car vw = new Car("VW",120,3000.590);

        garage.addCar(bmw);
        garage.addCar(vw);

        Assert.assertEquals(garage.getCount(),2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullCarThrowException(){
        Garage garage = new Garage();
        Car car = null;

        garage.addCar(car);

    }

    @Test
    public void testGetCarCorrectWork(){
        Garage garage = new Garage();
        Car volvo = new Car("Volvo",90,156.23);
        Car fiat = new Car("Fiat",100,121.23);
        Car bmw = new Car("BMW",120,121.23);

        garage.addCar(volvo);
        garage.addCar(fiat);

        List<Car> carList = new ArrayList<>();
        carList.add(volvo);
        carList.add(fiat);

        Assert.assertEquals(garage.getCars(),carList);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveCorrectReturnCars(){
        Garage garage = new Garage();
        Car volvo = new Car("Volvo",90,156.23);
        Car fiat = new Car("Fiat",100,121.23);
        Car polo = new Car("Polo",200,121.23);

        garage.addCar(volvo);
        garage.addCar(polo);
        garage.addCar(fiat);

        List<Car> carList = new ArrayList<>();
        carList.add(polo);
        carList.add(fiat);
        Assert.assertEquals(garage.findAllCarsWithMaxSpeedAbove(95),carList);
    }

    @Test
    public void testFindAllCarsByBrandCorrect(){
        Garage garage = new Garage();
        Car volvo = new Car("Volvo",90,156.23);
        Car fiat = new Car("Fiat",100,121.23);
        Car polo = new Car("Polo",200,121.23);

        garage.addCar(volvo);
        garage.addCar(polo);
        garage.addCar(fiat);

        List<Car> carList = new ArrayList<>();
        carList.add(polo);

        garage.findAllCarsByBrand("Polo");
        Assert.assertEquals(garage.findAllCarsByBrand("Polo"),carList);
    }

    @Test
    public void testGetTheMostExpensiveCar(){
        Garage garage = new Garage();
        Car Audi = new Car("Audi",130,2000);
        Car Seat = new Car("Seat",140,5000);
        Car Ferrari = new Car("Ferrari",300,15000);

        garage.addCar(Audi);
        garage.addCar(Seat);
        garage.addCar(Ferrari);

        Car carSearch = garage.getTheMostExpensiveCar();
        Assert.assertEquals(carSearch,Ferrari);
    }

    @Test
    public void testGetTheMostExpensiveCarReturnNull(){
        Garage garage = new Garage();
        Car Audi = new Car("Audi",130,2000);
        Car Audi2 = new Car("Audi",130,2000);
        Car Seat = new Car("Seat",150,2000);

        garage.addCar(Audi);
        garage.addCar(Audi2);

        Assert.assertEquals(garage.getTheMostExpensiveCar(),Audi);
    }

}