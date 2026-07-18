package com.thozamile.shopbackend.example;

import java.time.LocalDateTime;

public record ProductReview(
    Long id,
    Long product_id,
    // Long user_id,  // Uncomment when you add users table
    Double rating,    // Between 1.0 and 5.0
    String comment,
    LocalDateTime created_at,
    LocalDateTime updated_at
) {
    
}