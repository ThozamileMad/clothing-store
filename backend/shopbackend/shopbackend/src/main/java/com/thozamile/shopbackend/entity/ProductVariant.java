package com.thozamile.shopbackend.entity;

import org.springframework.data.annotation.Id;

public record ProductVariant(
    @Id Long id,
    Long productId,
    String color,
    String size,  // Will be one of: XXS, XS, S, M, L, XL, XXL
    Integer stock
) {
       
}