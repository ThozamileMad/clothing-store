package com.thozamile.shopbackend.entity;

import org.springframework.data.annotation.Id;

public record Product(
    @Id Long id, 
    Long styleId, 
    Long typeId, 
    String name, 
    Double price, 
    String description
) {
    
}