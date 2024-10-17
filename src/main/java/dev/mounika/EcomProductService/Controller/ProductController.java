package dev.mounika.EcomProductService.Controller;

import dev.mounika.EcomProductService.Service.ProductService;
import dev.mounika.EcomProductService.dto.CreateProductRequestDTO;
import dev.mounika.EcomProductService.dto.ProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.InvalidInputException;
import dev.mounika.EcomProductService.mapper.ProductEntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("ProductService")
    public ProductService productService;

    @Cacheable(value = "product" )
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllproducts();
        return ResponseEntity.ok(products);
    }

    @Cacheable(value = "product", key = "#id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id) {
        if (id == null) {
            throw new InvalidInputException("Input is not correct");
        }
        return ResponseEntity.ok(productService.getProductById(id));


    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody CreateProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.updateProduct(productRequestDTO,id));
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductbyName(@PathVariable("productName") String productName) {
        return ResponseEntity.ok(productService.getProduct(productName));
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductbetween(@PathVariable("min") double minPrice, @PathVariable("max") double maxPrice) {
        return ResponseEntity.ok(productService.getProductBetween(minPrice, maxPrice));
    }
}


/*
Used for controller advice
    @GetMapping("/productexception")
    public ResponseEntity getProductException(){

        throw new RandomException("Exception occurred from Product");
    }

    for fakeStore calling:
        @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<FakeStoreProductResponseDTO> products = productService.getAllproducts();
        return ResponseEntity.ok(products);
    }
 */



