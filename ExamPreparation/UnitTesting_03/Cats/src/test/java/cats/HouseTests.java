package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    @Test
    public void testSetNameCorrect() {
        House house = new House("Timy", 10);

    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowException() {
        House house = new House(null, 5);

    }

    @Test(expected = NullPointerException.class)
    public void testCheckEmptyNameThrowException(){
        House house = new House("",1);
    }

    @Test
    public void testIsHungry(){
        Cat cat = new Cat("tedo");
        Assert.assertEquals(cat.isHungry(),true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowException() {
        House house = new House("Jaizz", -5);

    }

    @Test
    public void testGetNameCorrectly() {
        House house = new House("Mims", 5);
        String name = "Mims";

        Assert.assertEquals(house.getName(), name);
    }

    @Test
    public void testGetCapacityCorrectly() {
        House house = new House("Mims", 5);
        int testNumber = 5;

        Assert.assertEquals(house.getCapacity(), testNumber);
    }

    @Test
    public void testAddCatInHouseCorrectly() {
        House house = new House("Bortgham", 10);
        Cat cat = new Cat("Kity");

        house.addCat(cat);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowException() {
        House house = new House("Plovdiv", 0);
        Cat cat = new Cat("Teo");

        house.addCat(cat);
    }

    @Test
    public void testCountMethodCorrectly() {
        House house = new House("Varna", 5);
        Cat cat1 = new Cat("kiro");
        Cat cat2 = new Cat("miro");
        Cat cat3 = new Cat("gosho");

        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(cat3);

        int count = house.getCount();

        Assert.assertEquals(count, 3);
    }

    @Test
    public void testRemoveCatCorrectly() {
        House house = new House("London", 3);
        Cat cat1 = new Cat("sasho");
        Cat cat2 = new Cat("misho");

        house.addCat(cat1);
        house.addCat(cat2);

        house.removeCat("misho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrowException() {
        House house = new House("Burgas", 4);
        Cat cat = new Cat("alisiq");

        house.addCat(cat);
        house.removeCat("anji");

    }

    @Test
    public void testCatForSaleCorrectly() {
        House house = new House("Blagoevgrad", 5);
        Cat cat1 = new Cat("Joro");
        Cat cat2 = new Cat("Joro1");
        cat2.setHungry(false);

        house.addCat(cat1);
        house.catForSale("Joro");
    }

    @Test(expected = IllegalArgumentException.class)
   public void testCatForSaleThrowException(){
        House house = new House("SB",4);
        house.addCat(new Cat("Dima"));

        house.catForSale("petq");
    }

    @Test
    public void testStatisticsReturnCorrectly(){
        House house = new House("Sofia",8);
        house.addCat(new Cat("titi"));
        house.addCat(new Cat("vanq"));
        house.addCat(new Cat("iva"));

        String testText = "The cat titi, vanq, iva is in the house Sofia!";
        Assert.assertEquals(house.statistics(),testText);
    }
}
