package halfLife;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {

    @Test
    public void testConstructorCreatedCorrectly(){
        Player player = new Player("Jaizz",20);

    }

    @Test(expected = NullPointerException.class)
    public void testSetNullUsernameThrowException(){
        Player player = new Player(null,22);
    }

    @Test(expected = NullPointerException.class)
    public void testSetLessUsernameThrowException(){
        Player player = new Player("",22);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthThrowException(){
        Player player = new Player("az",-20);

    }

    @Test
    public void testGetHealthCorrectlyReturned(){
        Player player = new Player("Groys",10);

        Assert.assertEquals(player.getHealth(),10);
    }

    @Test
    public void testGetUsernameCorrectlyReturn(){
        Player player = new Player("Jonhy",23);

        Assert.assertEquals(player.getUsername(),"Jonhy");
    }

    @Test
    public void testAddGun(){
        Player player = new Player("Jaizz",20);
        Gun pistol = new Gun("Pistol",30);

        player.addGun(pistol);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullGunThrowException(){
        Player player = new Player("Kayn",100);
        Gun gun = null;

        player.addGun(gun);
    }

    @Test
    public void testRemoveGunCorrectly(){
        Player player = new Player("Lux",23);
        Gun laser = new Gun("Laser",90);
        Gun barrier = new Gun("Barrier",10);

        player.addGun(laser);
        player.addGun(barrier);

        player.removeGun(laser);
    }

    @Test
    public void testGetGunCorrectly(){
        Player player = new Player("Jax",23);
        Gun shield = new Gun("Shield",90);
        Gun barrier = new Gun("Barrier",10);

        player.addGun(shield);
        player.addGun(barrier);

        player.getGun("Shield");
    }

    @Test
    public void testGetGunsCorrectly(){
        Player player = new Player("Jax",123);
        Gun sword = new Gun("Sword",21);
        Gun barrier = new Gun("Barrier",153);

        player.addGun(sword);
        player.addGun(barrier);

        List<Gun> guns = new ArrayList<>();
        guns.add(sword);
        guns.add(barrier);

        Assert.assertEquals(player.getGuns(),guns);
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadPlayerThrowException(){
        Player player = new Player("Darius",0);
        player.takeDamage(5);
    }

    @Test
    public void testHealthLessThan0(){
        Player player = new Player("Lucian",5);
        player.takeDamage(6);

        Assert.assertEquals(player.getHealth(),0);
    }

    @Test
    public void testDecreaseHealthCorrectly(){
        Player player = new Player("Lucian",10);
        player.takeDamage(6);

        Assert.assertEquals(player.getHealth(),4);
    }

    @Test
    public void testGetGunReturnNull(){
        Player player = new Player("Corki",20);
        Gun gun1 = new Gun("Sword",26);

        player.addGun(gun1);

        Assert.assertEquals(player.getGun("Shield"),null);
    }
}
