package kata.supermarket;

import java.math.BigDecimal;

public class UnitProduct extends Product {

    private final BigDecimal pricePerUnit;

    public UnitProduct(String productId, final BigDecimal pricePerUnit) {
        this.productId = productId;
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}
