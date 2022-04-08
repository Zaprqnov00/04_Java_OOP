package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    @Test
    public void testCreateFarmCorrectly() {
        Farm farm = new Farm("King", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowException(){
        Farm farm = new Farm("King",-5);

    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowException(){
        Farm farm = new Farm(null,5);
        Farm farm1 = new Farm(" ",4);
    }

    @Test
    public void testGetNameCorrectly(){
        Farm farm = new Farm("King",5);

        Assert.assertEquals(farm.getName(),"King");
    }

    @Test
    public void testGetCapacityCorrectly(){
        Farm farm = new Farm("King",5);

        Assert.assertEquals(farm.getCapacity(),5);
    }

    @Test
    public void testAddAnimalInFarmCorrectly(){
        Farm farm = new Farm("King",5);
        Animal dog = new Animal("Dog",10);

        farm.add(dog);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFullFarm(){
        Farm farm = new Farm("King",0);
        Animal cat = new Animal("Cat",10);

        farm.add(cat);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowExceptionForEqualTypeAnimal(){
        Farm farm = new Farm("King",7);
        Animal cat = new Animal("Cat",10);
        Animal checkCat = new Animal("Cat",67);

        farm.add(cat);
        farm.add(checkCat);
    }

    @Test
    public void testGetCountOfAnimalsInFarm(){
        Farm farm = new Farm("King",100);
        Animal animal = new Animal("Parrot",4);
        Animal animal1 = new Animal("Dog",6);
        Animal animal2 = new Animal("Bird",48);

        farm.add(animal);
        farm.add(animal1);
        farm.add(animal2);

        Assert.assertEquals(farm.getCount(),3);
    }

    @Test
    public void testRemoveAnimalCorrectly(){
        Farm farm = new Farm("King",10);
        Animal chicken = new Animal("Chicken",4);
        Animal rabbit = new Animal("Rabbit",5);

        farm.add(chicken);
        farm.add(rabbit);

        Assert.assertEquals(farm.remove("Chicken"),true);
    }

    @Test
    public void testRemoveAnimalReturnFalse(){
        Farm farm = new Farm("King",10);
        Animal chicken = new Animal("Chicken",4);
        Animal rabbit = new Animal("Rabbit",5);

        farm.add(chicken);
        farm.add(rabbit);

        Assert.assertEquals(farm.remove("Pig"),false);
    }

    @Test
    public void testGetTypeAnimal(){
        Animal animal = new Animal("Bear",10);

        Assert.assertEquals(animal.getType(),"Bear");
    }

    @Test
    public void testGetAnimalEnergy(){
        Animal animal = new Animal("Dog",25.67);

        Assert.assertEquals(animal.getEnergy(),25.67,12);
    }
}
