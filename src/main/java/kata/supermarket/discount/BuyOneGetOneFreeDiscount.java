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
        return quantity
                .divideToIntegralValue(BUY_TWOITEMS)
                .multiply(((UnitProduct) product).oneOf().price())
                .setScale(2, RoundingMode.HALF_UP);
    }
}
