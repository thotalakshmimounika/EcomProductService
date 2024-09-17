package dev.mounika.EcomProductService.mapper;

import dev.mounika.EcomProductService.dto.CreateProductRequestDTO;
import dev.mounika.EcomProductService.dto.ProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setImageURL(product.getImageURL());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setCategory(product.getCategory().getName());

        return productResponseDTO;
    }
    public static Product convertCreateProductRequestDTOToProduct(CreateProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setRating(0);
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImageURL(productRequestDTO.getImageURL());
        return product;
    }
}
