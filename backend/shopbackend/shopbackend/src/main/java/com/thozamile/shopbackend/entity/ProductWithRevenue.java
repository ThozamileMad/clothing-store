package com.thozamile.shopbackend.entity;

public record ProductWithRevenue(
    Long id, 
    String name, 
    Double price, 
    String description,
    Double revenue
) {
    
}
