package com.thozamile.shopbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.entity.ProductImage;
import com.thozamile.shopbackend.repository.ProductImageRepository;

@RestController
@RequestMapping("/products/images")
public class ProductImageController {
    private final ProductImageRepository productImageRepository;

    private ProductImageController(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @GetMapping("/{requestedId}")
    private ResponseEntity<ProductImage> findById(@PathVariable Long requestedId) {
        Optional<ProductImage> productImage = productImageRepository.findById(requestedId);
        if (productImage.isPresent()) {
            return ResponseEntity.ok(productImage.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    @GetMapping("/product_id/{requestedProductId}")
    private ResponseEntity<ProductImage> findByProductId(@PathVariable Long requestedProductId) {
        List<ProductImage> productImage = productImageRepository.findByProductId(requestedProductId);
        if (!productImage.isEmpty()) {
            return ResponseEntity.ok(productImage.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
