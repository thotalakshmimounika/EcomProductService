package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.dto.CategoryResponseDTO;
import dev.mounika.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.mounika.EcomProductService.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategory(UUID id);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID id);
    Boolean deleteCategory(UUID id);
}
