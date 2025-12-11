package store.domain;

import java.util.Map;

public class Cashier {
    private final ProductInventory inventory;

    public Cashier(ProductInventory inventory) {
        this.inventory = inventory;
    }

    public Map<Product, Integer> getProducts() {
        return inventory.getProducts();
    }
}
