package com.thozamile.shopbackend.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.example.ProductReview;

@RestController
@RequestMapping("/products/reviews")
public class ProductReviewController {

    @GetMapping("/{requestedId}")
    private ResponseEntity<ProductReview> getProductReviewById(@PathVariable Long requestedId) {
        if (requestedId == null) {
            return ResponseEntity.notFound().build();
        }
        
        ProductReview productReview = new ProductReview(
            requestedId,
            1L,
            // 1L, User ID
            4.5,
            "Amazing Product!!!",
            LocalDateTime.of(2026, 7, 18, 9, 36, 45),
            LocalDateTime.of(2026, 7, 18, 9, 36, 45)
        );

        return ResponseEntity.ok(productReview);
    }

    @GetMapping("/product_id/{requestedProductId}")
    private ResponseEntity<ProductReview> getProductReviewByProductId(@PathVariable Long requestedProductId) {
        if (requestedProductId == null) {
            return ResponseEntity.notFound().build();
        }
        
        ProductReview productReview = new ProductReview(
            1L,
            requestedProductId,
            // 1L, User ID
            4.5,
            "Amazing Product!!!",
            LocalDateTime.of(2026, 7, 18, 9, 36, 45),
            LocalDateTime.of(2026, 7, 18, 9, 36, 45)
        );

        return ResponseEntity.ok(productReview);
    }

    @GetMapping("/user_id/{requestedUserId}")
    private ResponseEntity<ProductReview> getProductReviewByUserId(@PathVariable Long requestedUserId) {
        if (requestedUserId == null) {
            return ResponseEntity.notFound().build();
        }
        
        ProductReview productReview = new ProductReview(
            1L,
            1L,
            // requestedUserId, User ID
            4.5,
            "Amazing Product!!!",
            LocalDateTime.of(2026, 7, 18, 9, 36, 45),
            LocalDateTime.of(2026, 7, 18, 9, 36, 45)
        );

        return ResponseEntity.ok(productReview);
    }
    
}
