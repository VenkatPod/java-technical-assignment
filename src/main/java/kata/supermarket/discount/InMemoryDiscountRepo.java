package kata.supermarket.discount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class InMemoryDiscountRepo {

    public static List<Discount> repo = List.of(
            new BuyOneGetOneFreeDiscount("product-1"),
            new BuyOneKiloForHalfPriceDiscount("product-3"),
            new BuyOneKiloForHalfPriceDiscount("product-4")
    );

    public Optional<Discount> getAllDiscountsGivenProduct(String productID) {
        return repo.stream()
                .filter(discount -> discount.productID.equalsIgnoreCase(productID))
                .findFirst();

    }
}
