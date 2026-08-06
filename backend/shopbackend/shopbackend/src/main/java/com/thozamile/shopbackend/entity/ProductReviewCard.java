package com.thozamile.shopbackend.entity;

import java.time.LocalDateTime;

public record ProductReviewCard(
    Long id,
    Double rating,
    String firstName,
    String lastName,
    Boolean isVerified,
    String comment,
    LocalDateTime createdAt,
    String productName
) {
    
}
