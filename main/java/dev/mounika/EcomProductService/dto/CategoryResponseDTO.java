package dev.mounika.EcomProductService.dto;

import java.util.List;
import java.util.UUID;

public class CategoryResponseDTO {
    private UUID id;
    private String CategoryName;
    private List<ProductResponseDTO> products;
}
