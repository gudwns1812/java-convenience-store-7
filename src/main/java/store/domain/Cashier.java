package store.domain;

import java.util.Map;
import java.util.Map.Entry;

public class Cashier {
    private final ProductInventory inventory;

    public Cashier(ProductInventory inventory) {
        this.inventory = inventory;
    }

    public void handleOrder(Map<String, Integer> orders) {
        for (Entry<String, Integer> order : orders.entrySet()) {
            inventory.decrease(order.getKey(), order.getValue());
        }
    }

    public Map<Product, Integer> getProducts() {
        return inventory.getProducts();
    }
}
