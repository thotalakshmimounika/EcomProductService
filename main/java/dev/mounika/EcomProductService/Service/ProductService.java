package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.ProductnotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllproducts();
    Product getProductById(UUID id) throws ProductnotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product product, UUID id);
    boolean deleteProduct(UUID id);
    Product getProduct(String name);
    List<Product> getProductBetween(double min, double max);

}
