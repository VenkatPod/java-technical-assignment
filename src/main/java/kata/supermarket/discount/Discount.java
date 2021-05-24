package kata.supermarket.discount;

import kata.supermarket.Product;

import java.math.BigDecimal;

public abstract class Discount {

    public String productID;

    public abstract BigDecimal applyDiscount(BigDecimal quantity, Product product);
}
