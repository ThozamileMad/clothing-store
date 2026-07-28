package com.thozamile.shopbackend.entity;

import java.util.List;

public record ProductCard(
    Product info,
    ProductWithRevenue infoWithRevenue,
    ProductRatingSummary ratingSummary,
    List<ProductImage> images,
    List<ProductReview> reviews,
    List<ProductVariant> variants,
    DressStyle style,
    DressType type
) {
    
}
