package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.dto.CategoryResponseDTO;
import dev.mounika.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.mounika.EcomProductService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDTO getCategory(UUID id) {
        return null;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        return null;
    }

    @Override
    public CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID id) {
        return null;
    }

    @Override
    public Boolean deleteCategory(UUID id) {
        return null;
    }
}
