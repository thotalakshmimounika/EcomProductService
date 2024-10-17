package dev.mounika.EcomProductService.dto;

import dev.mounika.EcomProductService.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductResponseDTO implements Serializable {
    private int productId;
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageURL;
    private double rating;
}
