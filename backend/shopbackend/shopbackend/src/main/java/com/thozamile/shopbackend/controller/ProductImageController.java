package com.thozamile.shopbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.example.ProductImage;

@RestController
@RequestMapping("/products/images")
public class ProductImageController {

    @GetMapping("/{requestedId}")
    private ResponseEntity<ProductImage> getProductImageById(@PathVariable Long requestedId) {
        if (requestedId == null) {
            return ResponseEntity.notFound().build();
        }
        
        ProductImage productImage = new ProductImage(
            requestedId,
            1L,
            "www.image.jpg",
            1
        );

        return ResponseEntity.ok(productImage);
    }

    @GetMapping("/product_id/{requestedProductId}")
    private ResponseEntity<ProductImage> getProductImageByProductId(@PathVariable Long requestedProductId) {
        if (requestedProductId == null) {
            return ResponseEntity.notFound().build();
        }

        ProductImage productImage = new ProductImage(
            1L,
            requestedProductId,
            "www.image.jpg",
            1
        );

        return ResponseEntity.ok(productImage); 
    }
    
}
