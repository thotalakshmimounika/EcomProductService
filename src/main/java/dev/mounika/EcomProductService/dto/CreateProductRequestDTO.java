package dev.mounika.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateProductRequestDTO {

    private String name;
    private String description;
    private double price;
    private String imageURL;
    private UUID categoryId;

}
