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

        return Objects.equals(name, product.name) && price.equals(product.price) && Objects.equals(
                promotion.getClass(), product.promotion.getClass());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + price.hashCode();
        result = 31 * result + Objects.hashCode(promotion);
        return result;
    }

    public boolean isPromoted() {
        return promotion.isPromotion();
    }
}
