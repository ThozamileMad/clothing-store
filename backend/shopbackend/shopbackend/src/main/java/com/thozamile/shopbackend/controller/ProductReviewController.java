package com.thozamile.shopbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thozamile.shopbackend.entity.ProductReview;
import com.thozamile.shopbackend.entity.ProductReview;
import com.thozamile.shopbackend.repository.ProductReviewRepository;

@RestController
@RequestMapping("/products/reviews")
public class ProductReviewController {
    private final ProductReviewRepository productReviewRepository;

    private ProductReviewController(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }
    
    @GetMapping("/{requestedId}")
    private ResponseEntity<ProductReview> findById(@PathVariable Long requestedId) {
        Optional<ProductReview> productReview = productReviewRepository.findById(requestedId);
        if (productReview.isPresent()) {
            return ResponseEntity.ok(productReview.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/product_id/{requestedProductId}")
    private ResponseEntity<ProductReview> findByProductId(@PathVariable Long requestedProductId) {
        List<ProductReview> productReviews = productReviewRepository.findByProductId(requestedProductId);
        if (!productReviews.isEmpty()) {
            return ResponseEntity.ok(productReviews.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /* 
    @GetMapping("/user_id/{requestedUserId}")
    private ResponseEntity<ProductReview> getProductReviewByUserId(@PathVariable Long requestedUserId) {
        List<ProductReview> productReviews = productReviewRepository.findByUserId(requestedUserId);
        if (productReviews.isEmpty()) {
            return ResponseEntity.ok(productReviews.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    */

    @PostMapping
    private ResponseEntity<Void> createProductReview(
        @RequestBody ProductReview newProductReviewRequest, 
        UriComponentsBuilder ucb
    ) {
        ProductReview savedProductReview = productReviewRepository.save(newProductReviewRequest);
        URI locationOfNewProductReview = ucb
            .path("products/reviews/{id}")
            .buildAndExpand(savedProductReview.id())
            .toUri();
        return ResponseEntity.created(locationOfNewProductReview).build();
    }
}
