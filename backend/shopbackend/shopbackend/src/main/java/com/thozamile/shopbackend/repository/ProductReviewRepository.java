package com.thozamile.shopbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thozamile.shopbackend.entity.ProductReview;
import com.thozamile.shopbackend.entity.ProductRatingSummary;

public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
    List<ProductReview> findByProductId(Long productId);

    @Query("""
        SELECT 
            AVG(rating) AS average_rating
        FROM product_review
        WHERE product_id = :productId
        GROUP BY product_id
    """)
    Optional<ProductRatingSummary> findAverageRatingByProductId(@Param("productId") Long productId);

    @Query("""
        SELECT 
            pr.id, 
            pr.product_id,
            pr.user_id, 
            pr.rating, 
            pr.comment,
            pr.is_verified
        FROM product_review pr
        WHERE is_verified = true
        ORDER BY RANDOM()
        LIMIT :limit
    """)
    List<ProductReview> findAllRandomByIsVerified(@Param("limit") Integer limit);

    List<ProductReview> findAll(Pageable pageable);
}
