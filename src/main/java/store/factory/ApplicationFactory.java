package store.factory;

import java.util.HashMap;
import java.util.Map;
import store.controller.ConvenienceController;
import store.domain.Cashier;
import store.domain.Product;
import store.domain.ProductInventory;
import store.domain.promotion.Buy1Get1Free;
import store.domain.promotion.Buy2Get1Free;
import store.domain.promotion.NonePromotion;

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
        return new HashMap<>(Map.ofEntries(
                Map.entry(new Product("콜라", 1000, new Buy2Get1Free()), 10),
                Map.entry(new Product("콜라", 1000, new NonePromotion()), 10),
                Map.entry(new Product("사이다", 1000, new Buy2Get1Free()), 8),
                Map.entry(new Product("사이다", 1000, new NonePromotion()), 7),
                Map.entry(new Product("오렌지주스", 1800, new Buy1Get1Free()), 9),
                Map.entry(new Product("오렌지주스", 1800, new NonePromotion()), 0)
        ));
    }
}
