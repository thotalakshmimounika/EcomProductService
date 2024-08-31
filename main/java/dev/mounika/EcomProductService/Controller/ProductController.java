package dev.mounika.EcomProductService.Controller;

import dev.mounika.EcomProductService.Service.ProductService;
import dev.mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.mounika.EcomProductService.exception.InvalidInputException;
import dev.mounika.EcomProductService.exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<FakeStoreProductResponseDTO> products = productService.getAllproducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        if(id<1){
            throw new InvalidInputException("Input is not correct");
        }
        FakeStoreProductResponseDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);

    }
    @GetMapping("/productexception")
    public ResponseEntity getProductException(){
        throw new RandomException("Exception occurred from Product");
    }



}
