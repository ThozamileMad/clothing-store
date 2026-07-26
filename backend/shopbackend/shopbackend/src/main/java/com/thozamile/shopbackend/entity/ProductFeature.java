package com.thozamile.shopbackend.entity;

import java.util.List;

public record ProductFeature(
    Product info,
    List<ProductReview> reviews,
    List<ProductImage> images,
    List<ProductVariant> variants,
    DressStyle style,
    DressType type
) {
    
}
