package ua.ithillel;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private static final List<Product> productList = new ArrayList<>();

    private ProductList() {
    }

    public static void add(Product product) {
        productList.add(product);
    }

    public static Product getProduct(Product product) {
        int index = productList.indexOf(product);
        return index >= 0 ? productList.get(index) : null;
    }

    public static List<Product> getProductList() {
        return productList;
    }
}
