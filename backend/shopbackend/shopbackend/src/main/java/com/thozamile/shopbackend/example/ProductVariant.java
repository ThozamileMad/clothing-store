package com.thozamile.shopbackend.example;

public record ProductVariant(
    Long id,
    Long product_id,
    String color,
    String size,  // Will be one of: XXS, XS, S, M, L, XL, XXL
    Integer stock
) {
       
}