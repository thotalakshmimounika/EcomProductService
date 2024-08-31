package dev.mounika.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private int productId;
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageURL;
    private double rating;
}
