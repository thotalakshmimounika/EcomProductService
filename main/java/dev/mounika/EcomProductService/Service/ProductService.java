package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.dto.CreateProductRequestDTO;
import dev.mounika.EcomProductService.dto.ProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.ProductnotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllproducts();
    ProductResponseDTO getProductById(UUID id) throws ProductnotFoundException;
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(CreateProductRequestDTO product, UUID id);
    boolean deleteProduct(UUID id);
    ProductResponseDTO getProduct(String name);
    List<Product> getProductBetween(double min, double max);

}
