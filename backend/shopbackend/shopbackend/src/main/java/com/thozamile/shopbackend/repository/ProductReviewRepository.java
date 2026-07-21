package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.ProductReview;

public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
    List<ProductReview> findByProductId(Long productId);
    //List<ProductReview> findByUserId(Long userId);
}
