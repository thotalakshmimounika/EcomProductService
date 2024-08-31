package dev.mounika.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FakeStoreCartResponseDTO {
    private int id;
    private int userid;
    private String date;
    private List<ProductQuantityDTO> products;
    private int __v;
}
