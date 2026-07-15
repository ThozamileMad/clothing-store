package com.thozamile.shopbackend;

record Product(
    Long id, 
    Long style_id, 
    Long type_id, 
    String name, 
    Double price, 
    String description,
    String created_at,
    String updated_at
) {
    
}
