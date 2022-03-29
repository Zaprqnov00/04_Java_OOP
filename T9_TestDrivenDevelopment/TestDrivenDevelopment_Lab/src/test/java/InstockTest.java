import org.junit.Assert;
import org.junit.Test;

public class InstockTest {

    @Test
    public void testCountOfProductInStock(){
        Instock instock = setUpInstock();

        Assert.assertEquals(instock.getCount(),3);
    }

    @Test
    public void testContainsReturnTrue(){
        Instock instock = setUpInstock();
        Product apple = new Product("Apple",2,3);

        Assert.assertEquals(instock.contains(apple),true);
    }

    @Test
    public void testContainsReturnFalse(){
        Instock instock = setUpInstock();
        Product tiger = new Product("Tiger",2,3);

        Assert.assertEquals(instock.contains(tiger),false);
    }

    @Test
    public void testAddProductCorrectly(){
        Instock instock = setUpInstock();
        Product grape = new Product("Grape",5.40,4);

        instock.add(grape);
    }

    @Test
    public void testChangeQuantityOfProductCorrectly(){
        Instock instock = setUpInstock();

        instock.changeQuantity("Banana",10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityThrowException(){
        Instock instock = setUpInstock();

        instock.changeQuantity("Kiwi",15);
    }

    @Test
    public void testFindProductByIndex(){
        Instock instock = setUpInstock();

        instock.find(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindProductByIndexThrowException(){
        Instock instock = setUpInstock();

        instock.find(7);
    }

    @Test
    public void testFindProductByLabel(){
        Instock instock = setUpInstock();

        instock.findByLabel("Orange");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindProductByWrongLabelThrowException(){
        Instock instock = setUpInstock();

        instock.findByLabel("Oil");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderCorrectly(){
        Instock instock = setUpInstock();

        instock.findFirstByAlphabeticalOrder(3);
    }

    @Test
    public void testReturnProductByPriceInDescendingOrder(){
        Instock instock = setUpInstock();

        instock.findAllInRange(2,3);
    }

    @Test
    public void testReturnProductByPrice(){
        Instock instock = setUpInstock();
        instock.findAllByPrice(2.20);

    }

    @Test
    public void testReturnMostExpensiveProductsWithHighestPrice(){
        Instock instock = setUpInstock();
        instock.findFirstMostExpensiveProducts(2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testReturnMostExpensiveProductsWithHighestPriceThrowException(){
        Instock instock = setUpInstock();
        instock.findFirstMostExpensiveProducts(5);

    }

    @Test
    public void testReturnAllProductsEqualQuantity(){
        Instock instock = setUpInstock();
        instock.findAllByQuantity(2);
    }

    @Test
    public void returnAllProducts(){
        Instock instock = setUpInstock();

        instock.iterator();
    }
    public Instock setUpInstock(){
        Instock instock = new Instock();
        Product apple = new Product("Apple",2.20,2);
        Product orange = new Product("Orange",3.50,6);
        Product banana = new Product("Banana",1.60,3);

        instock.add(apple);
        instock.add(orange);
        instock.add(banana);
        return instock;
    }
}