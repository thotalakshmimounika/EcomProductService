package dev.Mounika.EcomProductService.controller;

import dev.Mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.Mounika.EcomProductService.entity.Product;
import dev.Mounika.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService; // field injection

    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}