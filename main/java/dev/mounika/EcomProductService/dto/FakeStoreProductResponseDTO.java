package dev.mounika.EcomProductService.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private int Id;
    private String Name;
    private String Description;
    private String ImageUrl;
    private double Price;
    private String Category;
}
