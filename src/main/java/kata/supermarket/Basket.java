package kata.supermarket;

import kata.supermarket.discount.InMemoryDiscountRepo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {
        private final List<Item> items;

        private final InMemoryDiscountRepo inMemoryDiscountRepo = new InMemoryDiscountRepo();

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        /**
         * TODO: This could be a good place to apply the results of
         * the discount calculations.
         * It is not likely to be the best place to do those calculations.
         * Think about how Basket could interact with something
         * which provides that functionality.
         */
        private BigDecimal discounts() {
            return items.stream()
                    .collect(Collectors.groupingBy(item -> item.getProduct().productId))
                    .entrySet()
                    .stream()
                    .map(productListEntry -> inMemoryDiscountRepo.getAllDiscountsGivenProduct(productListEntry.getKey())
                            .map(discount ->
                                    discount.applyDiscount(
                                            productListEntry.getValue().stream().map(Item::quantity).reduce(BigDecimal::add).get(),
                                            productListEntry.getValue().get(0).getProduct()))
                            .orElse(BigDecimal.ZERO))
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
         }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts()).setScale(2, RoundingMode.HALF_UP);
        }
    }
}
