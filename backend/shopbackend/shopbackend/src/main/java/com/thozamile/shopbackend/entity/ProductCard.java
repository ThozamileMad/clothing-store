package com.thozamile.shopbackend.entity;

import java.time.LocalDateTime;

public record ProductCard(
    Long id, 
    String name, 
    Double price, 
    String imageUrl, 
    Double averageRating,
    LocalDateTime createdAt
) {
    
}
