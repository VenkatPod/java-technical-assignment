package kata.supermarket.discount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryDiscountRepoTest {

    @Test
    public void getAllDiscountsGivenProduct_givenValidProductId_shouldReturnDiscount() {
        InMemoryDiscountRepo inMemoryDiscountRepo = new InMemoryDiscountRepo();
        assertTrue(inMemoryDiscountRepo.getAllDiscountsGivenProduct("product-1").isPresent());
    }

    @Test
    public void getAllDiscountsGivenProduct_givenInvalidProductId_shouldNotReturnDiscount() {
        InMemoryDiscountRepo inMemoryDiscountRepo = new InMemoryDiscountRepo();
        assertFalse(inMemoryDiscountRepo.getAllDiscountsGivenProduct("invalid").isPresent());
    }
}