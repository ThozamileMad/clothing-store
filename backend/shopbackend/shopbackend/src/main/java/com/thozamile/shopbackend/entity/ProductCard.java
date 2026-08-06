package com.thozamile.shopbackend.entity;

public record ProductCard(
    Long id, 
    String name, 
    Double price, 
    String imageUrl, 
    Double averageRating
) {
    
}
