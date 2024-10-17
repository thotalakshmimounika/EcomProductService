package dev.mounika.EcomProductService.repository;

import dev.mounika.EcomProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByName(String name);
    Product findFirstProductByName(String name);
    List<Product> findByPriceBetween(Double priceLow, Double priceHigh);

}
