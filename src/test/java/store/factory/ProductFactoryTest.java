package store.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductFactoryTest {

    @Test
    void 상품들을_입력받았을떄_입력_검증() {
        //given
        String input = "[사이다-2],[감자칩-1]";
        //when
        Map<String, Integer> order = ProductFactory.createOrder(input);
        //then
        assertThat(order)
                .containsExactly(
                        Map.entry("사이다", 2),
                        Map.entry("감자칩", 1)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"[사이다-2], [감자칩-1]", "사이다-2,감자칩-1", "[사이다-a]"})
    void 잘못된_입력_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ProductFactory.createOrder(input));
    }
}
