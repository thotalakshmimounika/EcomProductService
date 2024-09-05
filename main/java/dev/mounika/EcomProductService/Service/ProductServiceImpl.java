package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.ProductnotFoundException;
import dev.mounika.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllproducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID id) throws ProductnotFoundException {
        /*
        Product savedproduct = productRepository.findById(id).get();
        if (savedproduct == null) {
            throw new ProductnotFoundException("Product not found id: " + id);
        }
        return savedproduct;
        */
        return productRepository.findById(id).orElseThrow(
                () -> new ProductnotFoundException("Product not found for id "+id)
        );
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct =productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product, UUID id) {
        Product savedproduct =  productRepository.findById(id).orElseThrow(
                () -> new ProductnotFoundException("Product not found for id "+id)
        );
        savedproduct.setName(product.getName());
        savedproduct.setDescription(product.getDescription());
        savedproduct.setPrice(product.getPrice());
        savedproduct.setCategory(product.getCategory());
        savedproduct.setImageURL(product.getImageURL());
        savedproduct.setRating(product.getRating());
       savedproduct = productRepository.save(savedproduct);
       return savedproduct;

    }

    @Override
    public boolean deleteProduct(UUID id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product getProduct(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> getProductBetween(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice,maxPrice);
    }
}
