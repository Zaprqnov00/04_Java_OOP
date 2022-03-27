package T9_TestDrivenDevelopment.src.main.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InstockTest {


    @Test
    public void testContainsMethod() {
        Instock instock = new Instock();
        Product productMilk = new Product("Milk", 2.10, 1);
        instock.add(productMilk);
        Assert.assertEquals(instock.contains(productMilk), true);
    }

    @Test
    public void testAddProductInStock() {
        Instock instock = new Instock();
        Product product = new Product("Coffee", 1.20, 2);

        instock.add(product);
    }

    @Test
    public void testCountMethodInStock() {
        Instock instock = new Instock();
        Product orange = new Product("Orange", 1, 2);
        Product apple = new Product("Apple", 0.90, 1);
        Product sugar = new Product("Sugar", 1.20, 3);

        instock.add(orange);
        instock.add(apple);
        instock.add(sugar);

        Assert.assertEquals(instock.getCount(), 3);
    }

    @Test
    public void testFindProductByIndexInStock() {
        Instock instock = new Instock();
        Product oil = new Product("Oil", 6.10, 1);
        Product fish = new Product("Fish", 5.20, 1);
        Product meat = new Product("Meat", 10.50, 2);
        Product chocolate = new Product("Chocolate", 1.70, 2);

        instock.add(oil);
        instock.add(fish);
        instock.add(meat);
        instock.add(chocolate);

        Product productFindByIndex = instock.find(2);
        Assert.assertEquals(productFindByIndex, meat);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindProductByIndexShouldThrowException() {
        Instock instock = new Instock();
        Product drink = new Product("Beer", 1.10, 1);
        instock.add(drink);
        Product productSearchByIndex = instock.find(3);
    }

    @Test
    public void testMethodChangeQuantityInProductRight() {
        Instock instock = new Instock();
        Product product = new Product("Tea", 3.40, 1);

        instock.add(product);
        instock.changeQuantity("Tea", 3);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodChangeQuantityShouldThrowException() {
        Instock instock = new Instock();
        instock.add(new Product("Milk", 2, 3));
        instock.add(new Product("Tomatoes", 1.35, 4));

        instock.changeQuantity("Ice tea", 5);
    }

    @Test
    public void testSearchProductByLabel() {
        Instock instock = new Instock();
        Product cocaCola = new Product("Coca-Cola", 1.20, 1);

        instock.add(cocaCola);

        Product cocaColaSearch = instock.findByLabel("Coca-Cola");
        Assert.assertEquals(cocaColaSearch, cocaCola);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchProductByLabelShouldThrowException() {
        Instock instock = new Instock();

        instock.findByLabel("Ice cream");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderCorrectSort() {
        Instock instock = new Instock();
        Product banana = new Product("Banana", 1, 2);
        Product apple = new Product("Apple", 4, 2);
        Product yoghurt = new Product("Yoghurt", 1, 2);

        instock.add(banana);
        instock.add(apple);
        instock.add(yoghurt);
        instock.findFirstByAlphabeticalOrder(2);
    }

    @Test
    public void testFindAllInRange() {
        Instock instock = new Instock();
        Product banana = new Product("Banana", 1.20, 2);
        Product apple = new Product("Apple", 5.50, 2);
        Product yoghurt = new Product("Yoghurt", 10.50, 2);
        Product redOrange = new Product("RedOrange", 0.80, 2);
        Product kiwi = new Product("Kiwi", 0.90, 2);

        instock.add(banana);
        instock.add(apple);
        instock.add(yoghurt);
        instock.add(redOrange);
        instock.add(kiwi);

        instock.findAllInRange(1.00, 5.60);
    }

    @Test
    public void testFindAllByPrice(){
        Instock instock = new Instock();
        Product bmw = new Product("BMW",100.50,1);
        Product train = new Product("BDJ",1000.65,2);
        Product audi = new Product("Audi",100.50,3);

        instock.add(bmw);
        instock.add(train);
        instock.add(audi);
        instock.findAllByPrice(100.50);

        List<Product> checkProducts = new ArrayList<>();
        checkProducts.add(bmw);
        checkProducts.add(audi);

        Assert.assertEquals(instock.findAllByPrice(100.50),checkProducts);
    }

    @Test
    public void testFindAllByQuantityProducts(){
        Instock instock = new Instock();
        Product bmw = new Product("BMW",100.50,3);
        Product train = new Product("BDJ",1000.65,2);
        Product audi = new Product("Audi",100.50,3);

        instock.add(bmw);
        instock.add(train);
        instock.add(audi);
        instock.findAllByQuantity(3);

        List<Product> checkProducts = new ArrayList<>();
        checkProducts.add(bmw);
        checkProducts.add(audi);

        Assert.assertEquals(instock.findAllByQuantity(3),checkProducts);
    }

    @Test
    public void testReturnAllProducts(){
        Instock instock = new Instock();
        instock.add(new Product("fish",1,1));
        instock.add(new Product("cream",1,1));

        instock.getIterable();

    }

    @Test
    public void testReturnProductsByHighestPrice(){
        Instock instock = new Instock();
        Product banana = new Product("Banana", 1.20, 2);
        Product apple = new Product("Apple", 5.50, 2);
        Product yoghurt = new Product("Yoghurt", 10.50, 2);
        Product redOrange = new Product("RedOrange", 0.80, 2);
        Product kiwi = new Product("Kiwi", 0.90, 2);

        instock.add(banana);
        instock.add(apple);
        instock.add(yoghurt);
        instock.add(redOrange);
        instock.add(kiwi);

        instock.findFirstMostExpensiveProducts(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReturnProductsWithHighestPriceThrowException(){
        Instock instock = new Instock();

        instock.findFirstMostExpensiveProducts(3);
    }
}