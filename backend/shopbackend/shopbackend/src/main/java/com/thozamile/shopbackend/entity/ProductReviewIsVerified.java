package com.thozamile.shopbackend.entity;

import java.time.LocalDateTime;

public record ProductReviewIsVerified(
    Long id,
    Long productId,
    Long userId,
    Double rating,
    String comment,
    LocalDateTime createdAt,
    Boolean isVerified
) {
    
}
