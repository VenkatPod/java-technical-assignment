package kata.supermarket;

import java.math.BigDecimal;

public interface Item {
    BigDecimal price();
    public Product getProduct();
    public BigDecimal quantity();
}
