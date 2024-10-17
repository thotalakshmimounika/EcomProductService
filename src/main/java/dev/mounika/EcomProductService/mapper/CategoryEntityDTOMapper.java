package dev.mounika.EcomProductService.mapper;

import dev.mounika.EcomProductService.dto.CategoryResponseDTO;
import dev.mounika.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.mounika.EcomProductService.dto.ProductResponseDTO;
import dev.mounika.EcomProductService.entity.Category;
import dev.mounika.EcomProductService.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper {
    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category){
        //call product entity to product response dto mapper
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getName());
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        if(!(category.getProducts() == null || category.getProducts().isEmpty())) {
            for (Product product : category.getProducts()) {
                productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
            }
        }
        categoryResponseDTO.setProducts(productResponseDTOs);
        return categoryResponseDTO;
    }

    public static Category convertCreateCategoryDTOToCategory(CreateCategoryRequestDTO createCategoryRequestDTO){
        Category category = new Category();
        category.setName(createCategoryRequestDTO.getCategoryName());
        return category;
    }
}
