package dev.mounika.EcomProductService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello World");
    }

}
