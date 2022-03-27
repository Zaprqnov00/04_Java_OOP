package T8_UnitTesting.Lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    @Test
    public void testAxeAttackDummyLoseDurability(){
        Axe axe = new Axe(10,10);
        Dummy dummy = new Dummy(10,10);

        axe.attack(dummy);

        Assert.assertEquals(axe.getDurabilityPoints(),9);
    }

    @Test(expected = IllegalStateException.class)
    public void testBrokenAxeShouldThrowException(){
        Axe axe = new Axe(10,0);
        Dummy dummy = new Dummy(10,10);

        axe.attack(dummy);

    }

    @Test
    public void testGettersInAxe(){
        Axe axe = new Axe(5,10);
        Assert.assertEquals(axe.getAttackPoints(),5);
        Assert.assertEquals(axe.getDurabilityPoints(),10);
    }
}