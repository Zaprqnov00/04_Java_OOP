package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    @Test(expected = OperationNotSupportedException.class)
    public void testNullConstructorThrowException() throws OperationNotSupportedException {
        String[] elements = null;
        ListIterator listIterator = new ListIterator(elements);

    }

    @Test
    public void testSuccessfullyCreateConstructor() throws OperationNotSupportedException {
        String[] elements = {"Apple","Pie","Cake"};
        ListIterator listIterator = new ListIterator(elements);
    }


    @Test
    public void testReturnFalseMoveCommand() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Car");

        Assert.assertEquals(listIterator.move(),false);
    }

    @Test
    public void testReturnTrueMoveCommand() throws OperationNotSupportedException {
        String[] elements = {"BMW","AUDI","VW"};
        ListIterator listIterator = new ListIterator(elements);

        Assert.assertEquals(listIterator.move(),true);
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintCommandShouldThrowExceptionForNullElements() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintCommandShouldReturnElementIndex() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Apple");
        listIterator.print();
    }

}