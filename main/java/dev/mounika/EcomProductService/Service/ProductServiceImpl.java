package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.dto.CreateProductRequestDTO;
import dev.mounika.EcomProductService.dto.ProductResponseDTO;
import dev.mounika.EcomProductService.entity.Category;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.CategoryNotFoundException;
import dev.mounika.EcomProductService.exception.ProductnotFoundException;
import dev.mounika.EcomProductService.mapper.ProductEntityDTOMapper;
import dev.mounika.EcomProductService.repository.CategoryRepository;
import dev.mounika.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllproducts() {

        List<Product> savedProducts =  productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for(Product product : savedProducts){
            productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));

        }
        return productResponseDTOs;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) throws ProductnotFoundException {
        /*
        Product savedproduct = productRepository.findById(id).get();
        if (savedproduct == null) {
            throw new ProductnotFoundException("Product not found id: " + id);
        }
        return savedproduct;
        */
        Product product= productRepository.findById(id).orElseThrow(
                () -> new ProductnotFoundException("Product not found for id "+id)
        );
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        Product product = ProductEntityDTOMapper.convertCreateProductRequestDTOToProduct(productRequestDTO);
        Category savedCategory = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow
                (
                  () -> new CategoryNotFoundException("Category not found for id "+productRequestDTO.getCategoryId())
                );
        product.setCategory(savedCategory);
        product = productRepository.save(product);
        return ProductEntityDTOMapper.
                convertProductEntityToProductResponseDTO(product);
    }
//can't update rating and category of a poduct while trying to update the details
    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO createProductRequestDTO, UUID id) {
        Product savedproduct =  productRepository.findById(id).orElseThrow(
                () -> new ProductnotFoundException("Product not found for id "+id)
        );
        savedproduct.setName(createProductRequestDTO.getName());
        savedproduct.setDescription(createProductRequestDTO.getDescription());
        savedproduct.setPrice(createProductRequestDTO.getPrice());
        savedproduct.setImageURL(createProductRequestDTO.getImageURL());
       savedproduct = productRepository.save(savedproduct);
       return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedproduct);

    }

    @Override
    public boolean deleteProduct(UUID id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public ProductResponseDTO getProduct(String name) {

        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO
                ( productRepository.findProductByName(name)
                );
    }

    @Override
    public List<Product> getProductBetween(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice,maxPrice);
    }
}
