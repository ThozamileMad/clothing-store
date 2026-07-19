package com.thozamile.shopbackend.entity;

import org.springframework.data.annotation.Id;

public record ProductImage(
    @Id Long id,
    Long productId,
    String url,
    Integer displayOrder
) {
    
}