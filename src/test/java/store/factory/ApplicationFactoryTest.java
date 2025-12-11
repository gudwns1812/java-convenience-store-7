package store.factory;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import store.domain.Product;
import store.domain.ProductInventory;
import store.domain.promotion.NonePromotion;

class ApplicationFactoryTest {

    private ApplicationFactory factory = new ApplicationFactory();

    @Test
    void 초기_상품_세팅() {
        //given
        ProductInventory inventory = factory.productInventory();
        Product cola = new Product("콜라", 1000, new NonePromotion());
        //when
        Map<Product, Integer> products = inventory.getProducts();
        //then
        Assertions.assertThat(products)
                .containsKey(cola);
    }
}
