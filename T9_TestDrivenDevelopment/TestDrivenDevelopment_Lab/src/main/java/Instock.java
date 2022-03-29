import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> productList;

    public Instock() {
        this.productList = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return this.productList.size();
    }

    @Override
    public boolean contains(Product product) {
        List<Product> checkProductByLabel = productList
                .stream().filter(p -> p.getLabel().equals(product.getLabel()))
                .collect(Collectors.toList());

        if (!checkProductByLabel.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void add(Product product) {
        if (!contains(product)) {
            productList.add(product);
        }
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        boolean changeSuccessfully = false;
        for (Product productSearch : productList) {
            if (productSearch.getLabel().equals(product)) {
                productSearch.setQuantity(quantity);
                changeSuccessfully = true;
                break;
            }
        }
        if (!changeSuccessfully) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= productList.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        List<Product> product = productList
                .stream()
                .filter(p -> p.getLabel().equals(label))
                .limit(1)
                .collect(Collectors.toList());

        Product productSearch = null;
        if (product.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            for (Product prod : product) {
                productSearch = prod;
                break;
            }
        }
        return productSearch;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        List<Product> sortedProductsByLabelInAscendingOrder = productList
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
        return sortedProductsByLabelInAscendingOrder;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> returnProductsByLowerAndHighestPrice = productList
                .stream()
                .filter(product -> product.getPrice() <= lo || product.getPrice() >= hi)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());

        return returnProductsByLowerAndHighestPrice;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> returnProductsByPrice = productList
                .stream()
                .filter(product -> product.getPrice() == price)
                .collect(Collectors.toList());

        return returnProductsByPrice;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        List<Product> returnExpensiveProductWithHighestPrice = productList
                .stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());

        if (returnExpensiveProductWithHighestPrice.size() < count) {
            throw new IllegalArgumentException();
        }

        return returnExpensiveProductWithHighestPrice;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        List<Product> returnProductsByQuantity = productList
                .stream()
                .filter(product -> product.getQuantity() == quantity)
                .collect(Collectors.toList());

        return returnProductsByQuantity;
    }

    @Override
    public Iterator<Product> iterator() {
        return productList.iterator();
    }

}
