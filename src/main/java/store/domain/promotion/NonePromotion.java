package store.domain.promotion;

import store.domain.Promotion;

public class NonePromotion implements Promotion {
    @Override
    public boolean isPromotion() {
        return false;
    }
}
