package store.domain;

public class Money {
    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public Money plus(Money other) {
        return new Money(amount + other.amount);
    }

    public Money minus(Money other) {
        return new Money(amount - other.amount);
    }

    public int getValue() {
        return amount;
    }

    public static Money won(int amount) {
        return new Money(amount);
    }
}
