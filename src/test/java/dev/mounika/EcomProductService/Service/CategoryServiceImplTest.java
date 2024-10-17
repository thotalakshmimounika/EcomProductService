package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.entity.Category;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.repository.CategoryRepository;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }
    @Test
     public void testGetTotalPriceForMultipleProductsUnderCategory(){
        UUID uuid = UUID.randomUUID();
        Optional<Category> categoryOptionalMockdata = getCategoryMockData();
         Mockito.when(categoryRepository.findById(uuid)).thenReturn(categoryOptionalMockdata);
         double actualTotalCost = categoryService.getTotalPriceForCategory(uuid);
         double expectedTotalCost = 300.00;
         Assertions.assertEquals(expectedTotalCost, actualTotalCost);

     }

     public Optional<Category> getCategoryMockData(){
        UUID randomeId = UUID.randomUUID();
        Category category = new Category();
        category.setId(randomeId);
        category.setName("Random Name");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setPrice(100.00);
        product1.setCategory(category);

         Product product2 = new Product();
         product2.setId(UUID.randomUUID());
         product2.setPrice(200.00);
         product2.setCategory(category);

         List<Product> products = new ArrayList<>();
         products.add(product1);
         products.add(product2);
         category.setProducts(products);
         return Optional.of(category);

     }


}
