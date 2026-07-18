package com.thozamile.shopbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.example.ProductVariant;

@RestController
@RequestMapping("/products/variants")
public class ProductVariantController {

    @GetMapping("/{requestedId}")
    private ResponseEntity<ProductVariant> getProductVariantById(@PathVariable Long requestedId) {
        if (requestedId == null) {
            return ResponseEntity.notFound().build();
        }
        
        ProductVariant productVariant = new ProductVariant(
            requestedId,
            1L,
            "white",
            "S",
            20
        );

        return ResponseEntity.ok(productVariant);
    }

    @GetMapping("/product_id/{requestedProductId}")
    private ResponseEntity<ProductVariant> getProductVariantByProductId(@PathVariable Long requestedProductId) {
        if (requestedProductId == null) {
            return ResponseEntity.notFound().build();
        }
        
        ProductVariant productVariant = new ProductVariant(
            1L,
            requestedProductId,
            "white",
            "S",
            20
        );

        return ResponseEntity.ok(productVariant);
    }
    
}
