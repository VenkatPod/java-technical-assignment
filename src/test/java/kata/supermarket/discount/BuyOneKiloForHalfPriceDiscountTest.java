package kata.supermarket.discount;

import kata.supermarket.WeighedProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyOneKiloForHalfPriceDiscountTest {

    @ParameterizedTest(name = "#{index} - Run test given input {arguments}")
    @MethodSource({"givenNItemsAndExpect"})
    void applyDiscount_givenNItems__WhenOneKiloHalfPrice_shouldReturnExpectedDiscountedPrice(BigDecimal productPrice,
                                                                                             BigDecimal quantity,
                                                                                             BigDecimal expectedTotalDiscount) {
        BuyOneKiloForHalfPriceDiscount buyOneKiloForHalfPriceDiscount =
                new BuyOneKiloForHalfPriceDiscount("");
        assertEquals(
                expectedTotalDiscount,
                buyOneKiloForHalfPriceDiscount.applyDiscount(quantity, new WeighedProduct("", productPrice)));
    }

    @Test
    private static List<Arguments> givenNItemsAndExpect() {
        return List.of(
                Arguments.of(BigDecimal.valueOf(0.99), unitInKilo(1), BigDecimal.valueOf(0.50).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.50), unitInKilo(2), BigDecimal.valueOf(1.50).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.00), unitInKilo(2), BigDecimal.valueOf(1.00).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.50), unitInKilo(3), BigDecimal.valueOf(2.25).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.00), unitInKilo(3), BigDecimal.valueOf(1.50).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.50), unitInKilo(0.5), BigDecimal.ZERO),
                Arguments.of(BigDecimal.valueOf(1.50), unitInKilo(1.75), BigDecimal.valueOf(0.75).setScale(2)),
                Arguments.of(BigDecimal.valueOf(1.64), unitInKilo(1.10), BigDecimal.valueOf(0.82).setScale(2))
        );
    }

    private static BigDecimal unitInKilo(double unit){
        return BigDecimal.valueOf(unit);
    }

}