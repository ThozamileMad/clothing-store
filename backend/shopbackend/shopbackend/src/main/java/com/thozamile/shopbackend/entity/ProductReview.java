package com.thozamile.shopbackend.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public record ProductReview(
    @Id Long id,
    Long productId,
    Long userId,  // Uncomment when you add users table
    Double rating,    // Between 1.0 and 5.0
    String comment,
    Boolean isVerified,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    
}