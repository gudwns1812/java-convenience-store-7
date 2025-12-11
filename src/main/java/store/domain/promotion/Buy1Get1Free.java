package store.domain.promotion;

import store.domain.Promotion;

public class Buy1Get1Free implements Promotion {
    @Override
    public boolean isPromotion() {
        return true;
    }
}
