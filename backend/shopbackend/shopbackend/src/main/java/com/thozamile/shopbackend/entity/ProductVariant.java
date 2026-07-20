package com.thozamile.shopbackend.entity;

public record ProductVariant(
    Long id,
    Long productId,
    String color,
    String size,  // Will be one of: XXS, XS, S, M, L, XL, XXL
    Integer stock
) {
       
}