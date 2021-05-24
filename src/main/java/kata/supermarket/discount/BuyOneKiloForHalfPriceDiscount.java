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
        return BigDecimal.ZERO;
    }
}
