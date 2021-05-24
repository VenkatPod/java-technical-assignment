package kata.supermarket.discount;

import kata.supermarket.UnitProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyOneGetOneFreeDiscountTest {

    @ParameterizedTest(name = "#{index} - Run test given input {arguments}")
    @MethodSource({"givenNItemsAndExpect"})
    void applyDiscount_givenNItems__WhenBuyOneGetOneFree_shouldReturnDiscountedPrice(BigDecimal productPrice,
                                                                                     BigDecimal quantity,
                                                                                     BigDecimal expectedTotalDiscount) {
        BuyOneGetOneFreeDiscount buyOneGetOneFreeDiscount = new BuyOneGetOneFreeDiscount("");
        assertEquals(
                expectedTotalDiscount,
                buyOneGetOneFreeDiscount.applyDiscount(quantity, new UnitProduct("", productPrice)));
    }

    @Test
    private static List<Arguments> givenNItemsAndExpect() {
        return List.of(
                Arguments.of(BigDecimal.valueOf(1.50), unitOf(1), BigDecimal.ZERO),
                Arguments.of(BigDecimal.valueOf(1.50), unitOf(2), BigDecimal.valueOf(1.50).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.00), unitOf(2), BigDecimal.valueOf(1.00).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.75), unitOf(3), BigDecimal.valueOf(1.75).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.02), unitOf(3), BigDecimal.valueOf(1.02).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.25), unitOf(4), BigDecimal.valueOf(2.50).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.17), unitOf(5), BigDecimal.valueOf(2.34).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.07), unitOf(6), BigDecimal.valueOf(3.21).setScale(2))
        );
    }

    private static BigDecimal unitOf(int i){
        return BigDecimal.valueOf(i);
    }

}