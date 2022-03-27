package T9_TestDrivenDevelopment.src.main.java;

import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> productList;

    public Instock() {
        this.productList = new ArrayList<>();
    }

    public Iterable<Product> getIterable() {
        return productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public boolean contains(Product product) {
        if (productList.contains(product)) {
            return true;
        }
        return false;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        boolean searchProduct = false;
        for (Product productFix : productList) {
            if (productFix.getLabel().equals(product)) {
                productFix.setQuantity(quantity);
                searchProduct = true;
                break;
            }
        }
        if (!searchProduct) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        if (index >= productList.size() - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        for (Product productSearchByLabel : productList) {
            if (productSearchByLabel.getLabel().equals(label)) {
                return productSearchByLabel;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        List<Product> productByLabel = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            for (Product product : productList) {
                productByLabel.add(product);
                break;
            }
        }
        productByLabel = productByLabel.stream().sorted(Comparator.comparing(Product::getLabel)).collect(Collectors.toList());
        return productByLabel;
    }

    @Override
    public Iterable<Product> findAllInRange(double lowerPrice, double highestPrice) {
        List<Product> productsWithLowerAndHighestPrice = new ArrayList<>();
        for (Product product : productList) {
            if (product.getPrice() <= lowerPrice || product.getPrice() >= highestPrice) {
                productsWithLowerAndHighestPrice.add(product);
            }
        }
        productsWithLowerAndHighestPrice = productsWithLowerAndHighestPrice.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed()).collect(Collectors.toList());
        return productsWithLowerAndHighestPrice;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> productsWithThisPrice = new ArrayList<>();
        for (Product product : productList) {
            if (product.getPrice() == price) {
                productsWithThisPrice.add(product);
            }
        }
        return productsWithThisPrice;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        List<Product> productsSortedByPrice = productList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());

        List<Product> productsWthHighestPrice = new ArrayList<>();

        for (Product product :productsSortedByPrice) {
            if (count == 0){
                break;
            }
            count--;
            productsWthHighestPrice.add(product);
        }

        if (productsWthHighestPrice.size() < count){
            throw new IllegalArgumentException();
        }

        return productsWthHighestPrice;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        List<Product> productsWithThisQuantity = new ArrayList<>();
        for (Product product : productList) {
            if (product.getQuantity() == quantity) {
                productsWithThisQuantity.add(product);
            }
        }
        return productsWithThisQuantity;
    }

    @Override
    public Iterator<Product> iterator() {
        return productList.listIterator();
    }
}
