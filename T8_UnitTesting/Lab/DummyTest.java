package T8_UnitTesting.Lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    @Test
    public void testDummyLoseHealth(){
        Dummy dummy = new Dummy(10,15);
        dummy.takeAttack(8);

        Assert.assertEquals(dummy.getHealth(),2);
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyDeadMethod(){
        Dummy dummy = new Dummy(0,10);

        dummy.takeAttack(5);
    }

    @Test
    public void testDummyGiveExperience(){
        Dummy dummy = new Dummy(-5,10);
        dummy.giveExperience();
        Assert.assertEquals(dummy.giveExperience(),10);
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyCantGiveExperience(){
        Dummy dummy = new Dummy(10,20);

        dummy.giveExperience();
    }
}