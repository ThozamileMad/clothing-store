package com.thozamile.shopbackend.entity;

import org.springframework.data.annotation.Id;

public record ProductReview(
    @Id Long id,
    Long productId,
    Long userId,  // Uncomment when you add users table
    Double rating,    // Between 1.0 and 5.0
    String comment
) {
    
}