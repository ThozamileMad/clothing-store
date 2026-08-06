package com.thozamile.shopbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thozamile.shopbackend.entity.ProductReview;
import com.thozamile.shopbackend.entity.ProductReviewIsVerified;
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
            pr.comment
        FROM product_review pr
        WHERE EXISTS (
            SELECT 1
            FROM sale s
            WHERE 
                s.user_id = pr.user_id AND 
                s.product_id  = pr.product_id
        )
        ORDER BY RANDOM()
        LIMIT :limit
    """)
    List<ProductReview> findAllOrderByRandomByDistinct(@Param("limit") Integer limit);

    @Query("""
        SELECT
            pr.id, 
            pr.product_id,
            pr.user_id, 
            pr.rating, 
            pr.comment,
            pr.created_at,
            EXISTS (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id = pr.user_id AND 
                    s.product_id  = pr.product_id
            ) AS is_verified
        FROM product_review pr
        ORDER BY pr.created_at DESC
        LIMIT :limit
    """)
    List<ProductReviewIsVerified> findAllOrderByCreatedAtDesc(@Param("limit") Integer limit);

    @Query("""
        SELECT
            pr.id, 
            pr.product_id,
            pr.user_id, 
            pr.rating, 
            pr.comment,
            pr.created_at,
            EXISTS (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id = pr.user_id AND 
                    s.product_id  = pr.product_id
            ) AS is_verified
        FROM product_review pr
        ORDER BY pr.created_at ASC
        LIMIT :limit
    """)
    List<ProductReviewIsVerified> findAllOrderByCreatedAtAsc(@Param("limit") Integer limit);

    @Query("""
        SELECT
            pr.id, 
            pr.product_id,
            pr.user_id, 
            pr.rating, 
            pr.comment,
            pr.created_at,
            EXISTS (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id = pr.user_id AND 
                    s.product_id  = pr.product_id
            ) AS is_verified
        FROM product_review pr
        WHERE (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id = pr.user_id AND 
                    s.product_id  = pr.product_id
            ) = :isVerified
        ORDER BY pr.created_at DESC
        LIMIT :limit
    """)
    List<ProductReviewIsVerified> findAllIsVerifiedOrderByCreatedAtDesc(
        @Param("isVerified") Boolean isVerified,
        @Param("limit") Integer limit
    );

    @Query("""
        SELECT
            pr.id, 
            pr.product_id,
            pr.user_id, 
            pr.rating, 
            pr.comment,
            pr.created_at,
            EXISTS (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id = pr.user_id AND 
                    s.product_id  = pr.product_id
            ) AS is_verified
        FROM product_review pr
        WHERE (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id != pr.user_id AND 
                    s.product_id  != pr.product_id
            ) = :isVerified
        ORDER BY pr.created_at ASC
        LIMIT :limit
    """)
    List<ProductReviewIsVerified> findAllIsVerifiedOrderByCreatedAtAsc(
        @Param("isVerified") Boolean isVerified, 
        @Param("limit") Integer limit 
    );

    /* 
    

    @Query("""
        SELECT
            pr.id, 
            pr.product_id,
            pr.user_id, 
            pr.rating, 
            pr.comment,
            pr.created_at,
            EXISTS (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id = pr.user_id AND 
                    s.product_id  = pr.product_id
            ) AS is_verified
        FROM product_review pr
        WHERE is_verified = :isVerified
        ORDER BY pr.created_at ASC
    """)
    List<ProductReviewIsVerified> findAllIsVerifiedOrderByCreatedAtAsc(Boolean isVerified);

    @Query("""
        SELECT
            pr.id, 
            pr.product_id,
            pr.user_id, 
            pr.rating, 
            pr.comment,
            pr.created_at,
            EXISTS (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id = pr.user_id AND 
                    s.product_id  = pr.product_id
            ) AS is_verified
        FROM product_review pr
        ORDER BY pr.rating DESC
    """)
    List<ProductReviewIsVerified> findAllIsVerifiedOrderByRatingDesc();

    @Query("""
        SELECT
            pr.id, 
            pr.product_id,
            pr.user_id, 
            pr.rating, 
            pr.comment,
            pr.created_at,
            EXISTS (
                SELECT 1
                FROM sale s
                WHERE 
                    s.user_id = pr.user_id AND 
                    s.product_id  = pr.product_id
            ) AS is_verified
        FROM product_review pr
        WHERE 
        ORDER BY pr.rating ASC
    """)
    List<ProductReviewIsVerified> findAllIsVerifiedOrderByRatingAsc();
    */

}
