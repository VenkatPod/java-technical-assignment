package kata.supermarket.discount;

import kata.supermarket.Product;
import kata.supermarket.UnitProduct;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyOneGetOneFreeDiscount extends Discount {

    public static final BigDecimal BUY_TWOITEMS = BigDecimal.valueOf(2);

    public BuyOneGetOneFreeDiscount(String productID) {
        this.productID = productID;
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal quantity, Product product) {
        BigDecimal disQuantity = quantity.divideToIntegralValue(BUY_TWOITEMS);
        if (disQuantity.intValue() > 0) {
            BigDecimal productPrice = ((UnitProduct) product).oneOf().price();
            BigDecimal remaining = quantity.subtract(disQuantity.multiply(BigDecimal.valueOf(2)));
            return quantity.multiply(productPrice)
                    .subtract(remaining.multiply(productPrice)
                            .add(disQuantity.multiply(productPrice))).setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }
}
