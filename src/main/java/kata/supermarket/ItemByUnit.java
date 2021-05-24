package kata.supermarket;

import java.math.BigDecimal;


public class ItemByUnit implements Item {

    private final UnitProduct product;

    ItemByUnit(final UnitProduct product) {
        this.product = product;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public BigDecimal quantity() {
        return BigDecimal.ONE;
    }
}
