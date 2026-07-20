package com.thozamile.shopbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.entity.ProductVariant;
import com.thozamile.shopbackend.repository.ProductVariantRepository;

@RestController
@RequestMapping("/products/variants")
public class ProductVariantController {
    private final ProductVariantRepository productVariantRepository;

    private ProductVariantController(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    @GetMapping("/{requestedId}")
    private ResponseEntity<ProductVariant> findById(@PathVariable Long requestedId) {
        Optional<ProductVariant> productVariant = productVariantRepository.findById(requestedId);

        if (productVariant.isPresent()) {
            return ResponseEntity.ok(productVariant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/product_id/{requestedProductId}")
    private ResponseEntity<ProductVariant> findByProductId(@PathVariable Long requestedProductId) {
        List<ProductVariant> productVariant = productVariantRepository.findByProductId(requestedProductId);
        if (!productVariant.isEmpty()) {
            return ResponseEntity.ok(productVariant.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
