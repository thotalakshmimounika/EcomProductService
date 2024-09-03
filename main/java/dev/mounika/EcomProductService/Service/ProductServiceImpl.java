package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.ProductnotFoundException;
import dev.mounika.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ProductService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<FakeStoreProductResponseDTO> getAllproducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductResponseDTO getProductById(int id) throws ProductnotFoundException {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct =productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product, int id) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }
}
