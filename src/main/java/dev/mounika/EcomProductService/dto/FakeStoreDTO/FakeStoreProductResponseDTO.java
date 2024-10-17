package dev.mounika.EcomProductService.dto.FakeStoreDTO;

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
    private FakeStoreProductRatingDTO rating;
}
