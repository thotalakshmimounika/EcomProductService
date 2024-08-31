package dev.mounika.EcomProductService.mapper;

import dev.mounika.EcomProductService.dto.ProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setImageURL(product.getImageURL());
        productResponseDTO.setRating(product.getRating());

        return productResponseDTO;
    }
}
