package store.domain;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import store.domain.promotion.Buy2Get1Free;
import store.domain.promotion.NonePromotion;
import store.factory.ApplicationFactory;

class ProductInventoryTest {

    private ProductInventory inventory;

    @BeforeEach
    void setUp() {
        ApplicationFactory factory = new ApplicationFactory();
        inventory = factory.productInventory();
    }

    @Test
    void 상품을_구매하면_재고를_감소시킨다() {
        //given
        String input = "콜라";
        int count = 3;

        Product cola = new Product("콜라", 1000, new Buy2Get1Free());
        int productCount = 7;
        //when
        inventory.decrease(input, count);
        //then
        Assertions.assertThat(inventory.getProducts())
                .containsEntry(cola, productCount);
    }

    @Test
    void 프로모션_상품이_고갈되면_정가_상품에서_재고를_감소시킨다() {
        //given
        String input = "콜라";
        int count = 13;

        Product cola = new Product("콜라", 1000, new NonePromotion());
        int productCount = 7;
        //when
        inventory.decrease(input, count);
        //then
        Assertions.assertThat(inventory.getProducts())
                .containsEntry(cola, productCount);
    }

    @ParameterizedTest
    @MethodSource("productFail")
    void 상품구매_실패_테스트(String name, int count) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> inventory.decrease(name, count));
    }


    public static Stream<Arguments> productFail() {
        return Stream.of(
                Arguments.of("콜라", 23),
                Arguments.of("코라", 10)
        );
    }
}
