package com.thozamile.shopbackend.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public record Sales(
    @Id Long id,
    Long userId,
    Long variantId,
    Integer quantity,
    Double unitPrice,
    Double totalPrice,
    LocalDateTime soldAt
) {

}
