package com.thozamile.shopbackend.entity;

import java.util.List;

public record ProductDetailedCard(
    Long id, 
    Long typeId,
    String name, 
    String description,
    Double price,
    Double averageRating, 
    List<String> imageUrls, 
    List<String> colors,
    List<String> sizes
) {
    
}
