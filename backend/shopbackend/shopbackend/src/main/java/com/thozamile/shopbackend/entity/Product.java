package com.thozamile.shopbackend.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public record Product(
    @Id Long id, 
    Long styleId, 
    Long typeId, 
    String name, 
    Double price, 
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,

    @MappedCollection(idColumn = "PRODUCT_ID")
    Set<ProductImage> productImages,

    @MappedCollection(idColumn = "PRODUCT_ID")
    Set<ProductVariant> productVariants
) {

}