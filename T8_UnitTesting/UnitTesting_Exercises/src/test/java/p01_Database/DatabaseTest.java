package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Test
    public void testCapacityInArray() throws OperationNotSupportedException {
        Database database = new Database(10,20,55);
        Integer[] elements = {10,20,55};

        Assert.assertArrayEquals(database.getElements(),elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testLongerThanSixteenNumbersThrowException() throws OperationNotSupportedException {
       Integer[] elements = new Integer[18];

       Database database = new Database(elements);

    }

    @Test
    public void testAddOperation() throws OperationNotSupportedException{

        Integer[] testNumbers = new Integer[6];

        Database database = new Database(1,2,3,4,5);
        database.add(20);
        Assert.assertEquals(database.getElements().length,testNumbers.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullInArrayShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database(1,2,3,4);
        database.add(null);
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Database database = new Database(1,2,56);

        database.remove();

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveOperationThrowExceptionForEmptyDatabase() throws OperationNotSupportedException {

        Database database = new Database();

        database.remove();
    }


}