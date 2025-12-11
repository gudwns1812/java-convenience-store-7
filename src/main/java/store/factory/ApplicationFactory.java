package store.factory;

import java.util.Map;
import store.controller.ConvenienceController;
import store.domain.Cashier;
import store.domain.Product;
import store.domain.ProductInventory;
import store.domain.promotion.Buy2Get1Free;

public class ApplicationFactory {

    public ConvenienceController controller() {
        return new ConvenienceController(cashier());
    }

    public Cashier cashier() {
        return new Cashier(productInventory());
    }

    public ProductInventory productInventory() {
        return new ProductInventory(initialProducts());
    }

    public Map<Product, Integer> initialProducts() {
        return Map.ofEntries(
                Map.entry(new Product("콜라", 1000, new Buy2Get1Free()), 10)
        );
    }
}
