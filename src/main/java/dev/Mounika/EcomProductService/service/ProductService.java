package dev.Mounika.EcomProductService.service;

import dev.Mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.Mounika.EcomProductService.entity.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productId);
}