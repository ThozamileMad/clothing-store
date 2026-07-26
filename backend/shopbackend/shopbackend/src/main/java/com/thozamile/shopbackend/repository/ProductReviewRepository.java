package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thozamile.shopbackend.entity.ProductReview;

public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
    List<ProductReview> findByProductId(Long productId);

    @Query("""
        SELECT 
            product_id,
            AVG(rating) AS averageRating
            COUNT(*) AS reviewCount
        FROM product_review 
        WHERE product_id = :productId
        GROUP BY product_id
    """)
    List<ProductReview> findAllByAverageRating(@Param("productId") Long productId);
}
