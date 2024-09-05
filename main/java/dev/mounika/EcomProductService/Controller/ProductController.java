package dev.mounika.EcomProductService.Controller;

import dev.mounika.EcomProductService.Service.ProductService;
import dev.mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.InvalidInputException;
import dev.mounika.EcomProductService.exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<Product> products = productService.getAllproducts();
        return ResponseEntity.ok(products);
    }


    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id) {
        if (id == null) {
            throw new InvalidInputException("Input is not correct");
        }
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);

    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product, id);
        return ResponseEntity.ok(updateProduct);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity getProductbyName(@PathVariable("productName") String productName) {
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



