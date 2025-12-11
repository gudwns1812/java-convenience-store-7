package store.domain;

import java.util.Map;

public class ProductInventory {
    private final Map<Product, Integer> products;

    public ProductInventory(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return Map.copyOf(products);
    }
}
