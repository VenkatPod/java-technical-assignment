package kata.supermarket.discount;

import kata.supermarket.Product;
import kata.supermarket.UnitProduct;
import kata.supermarket.WeighedProduct;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyOneKiloForHalfPriceDiscount extends Discount {

    public BuyOneKiloForHalfPriceDiscount(String productId){
        this.productID = productId;
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal quantity, Product product) {
        quantity.setScale(2, RoundingMode.FLOOR);
        BigDecimal rounded = BigDecimal.valueOf(quantity.intValue());
        if (quantity.intValue() >= 1) {
            BigDecimal productPrice = ((WeighedProduct)product).weighing(BigDecimal.ONE).price();
            return rounded.multiply(productPrice.divide(BigDecimal.valueOf(2)))
                    .setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }
}
