package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.ProductnotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllproducts();
    FakeStoreProductResponseDTO getProductById(int id) throws ProductnotFoundException;
    Product addProduct(Product product);
    Product updateProduct(Product product, int id);
    boolean deleteProduct(int id);

}
