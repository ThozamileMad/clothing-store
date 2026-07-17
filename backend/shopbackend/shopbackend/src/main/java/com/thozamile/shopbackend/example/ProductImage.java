package com.thozamile.shopbackend.example;

public record ProductImage(
    Long id,
    Long product_id,
    String url,
    Integer display_order
) {
    
}