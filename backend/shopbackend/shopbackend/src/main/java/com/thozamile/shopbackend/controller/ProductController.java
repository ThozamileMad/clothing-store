package com.thozamile.shopbackend.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.example.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{requestedId}")
    private ResponseEntity<Product> findById(@PathVariable Long requestedId) {
        if (requestedId == null) {
            return ResponseEntity.notFound().build();
        }
        
        Product product = new Product(
            requestedId, 
            1L, 
            1L, 
            "Baggy Jeans", 
            37.99, 
            "Simple Baggy Jeans.",
            LocalDateTime.now(),
            LocalDateTime.now()
        );

        return ResponseEntity.ok(product);
    }
}
