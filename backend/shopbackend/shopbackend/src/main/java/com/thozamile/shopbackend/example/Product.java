package com.thozamile.shopbackend.example;

import java.time.LocalDateTime;

public record Product(
    Long id, 
    Long style_id, 
    Long type_id, 
    String name, 
    Double price, 
    String description,
    LocalDateTime created_at,
    LocalDateTime updated_at
) {
    
}