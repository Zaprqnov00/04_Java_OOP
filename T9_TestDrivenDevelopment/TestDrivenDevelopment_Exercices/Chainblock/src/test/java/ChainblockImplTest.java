import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest {

    @Test
    public void testAddTransactionCorrectly() {
        ChainblockImpl chainblock = new ChainblockImpl();
        Transaction transaction1 = new TransactionImpl(123, TransactionStatus.ABORTED, "mimi", "tedi", 100.50);

        chainblock.add(transaction1);
    }

    @Test
    public void testCountTransactionsInChainblock() {
        Chainblock chainblock = setUp();

        int allTransactions = chainblock.getCount();

        Assert.assertEquals(allTransactions, 3);
    }

    @Test
    public void testContainsTransactionByIdReturnTrue() {
        Chainblock chainblock = setUp();

        Assert.assertEquals(chainblock.contains(123), true);

    }

    @Test
    public void testContainsTransactionByIdReturnFalse() {
        Chainblock chainblock = setUp();

        Assert.assertEquals(chainblock.contains(125), false);
    }

    @Test
    public void testChangeTransactionStatusCorrectly() {
        Chainblock chainblock = setUp();

        chainblock.changeTransactionStatus(123, TransactionStatus.UNAUTHORIZED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowException() {
        Chainblock chainblock = setUp();

        chainblock.changeTransactionStatus(125, TransactionStatus.FAILED);
    }

    @Test
    public void testRemoveTransactionByIdCorrectly() {
        Chainblock chainblock = setUp();

        chainblock.removeTransactionById(1023);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowException() {
        Chainblock chainblock = setUp();

        chainblock.removeTransactionById(12);
    }

    @Test
    public void testGetTransactionByIdCorrectly() {
        Chainblock chainblock = new ChainblockImpl();
        Transaction transaction2 = new TransactionImpl(124, TransactionStatus.SUCCESSFUL, "pesho", "blago", 105.510);

        chainblock.add(transaction2);

        Assert.assertEquals(chainblock.getById(124), transaction2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTransactionByIdThrowException() {
        Chainblock chainblock = new ChainblockImpl();
        Transaction transaction2 = new TransactionImpl(124, TransactionStatus.SUCCESSFUL, "pesho", "blago", 105.510);

        chainblock.add(transaction2);

        Assert.assertEquals(chainblock.getById(15), transaction2);
    }

    @Test
    public void testGetTransactionByStatusCorrectly() {
        Chainblock chainblock = new ChainblockImpl();
        Transaction transaction1 = new TransactionImpl(123, TransactionStatus.ABORTED, "mimi", "tedi", 231.50);
        Transaction transaction2 = new TransactionImpl(643, TransactionStatus.ABORTED, "mitko", "kiro", 45213.67);
        Transaction transaction3 = new TransactionImpl(633, TransactionStatus.ABORTED, "mitko", "kiro", 5434341.67);

        chainblock.add(transaction1);
        chainblock.add(transaction2);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList = transactionList.stream().sorted(Comparator.comparingDouble(Transaction::amount).reversed()).collect(Collectors.toList());

        Assert.assertEquals(chainblock.getByTransactionStatus(TransactionStatus.ABORTED), transactionList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTransactionByStatusThrowException() {
        Chainblock chainblock = setUp();

        chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllInAmountRangeReturnResults() {
        Chainblock chainblock = setUp();

        chainblock.getAllInAmountRange(10, 7);
    }

    @Test
    public void testGetAllInAmountRangeReturnNewArrayList() {
        Chainblock chainblock = setUp();

        List<Transaction> testList = new ArrayList<>();
        Assert.assertEquals(chainblock.getAllInAmountRange(1,30),testList);
        chainblock.iterator();
    }

    //Todo: 8 methods not tested

    private Chainblock setUp() {
        ChainblockImpl chainblock = new ChainblockImpl();
        Transaction transaction1 = new TransactionImpl(123, TransactionStatus.ABORTED, "mimi", "tedi", 12.50);
        Transaction transaction2 = new TransactionImpl(124, TransactionStatus.SUCCESSFUL, "pesho", "blago", 22.90);
        Transaction transaction3 = new TransactionImpl(125, TransactionStatus.FAILED, "mitko", "kiro", 8.70);

        chainblock.add(transaction1);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        return chainblock;
    }
}