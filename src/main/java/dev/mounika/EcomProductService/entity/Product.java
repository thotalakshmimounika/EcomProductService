package dev.mounika.EcomProductService.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageURL;
    private double rating;

}
