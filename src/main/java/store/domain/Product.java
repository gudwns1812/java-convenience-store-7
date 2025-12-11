package store.domain;

import java.util.Objects;

public class Product {
    private final String name;
    private final Money price;
    private final Promotion promotion;

    public Product(String name, int price, Promotion promotion) {
        this.name = name;
        this.price = Money.won(price);
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price.getValue();
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Product product)) {
            return false;
        }

        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
