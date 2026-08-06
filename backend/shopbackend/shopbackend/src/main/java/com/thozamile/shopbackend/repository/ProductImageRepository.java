package com.thozamile.shopbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thozamile.shopbackend.entity.ProductImage;
import com.thozamile.shopbackend.entity.ProductImageUrl;

public interface ProductImageRepository extends CrudRepository<ProductImage, Long> {
    List<ProductImage> findAllByProductId(Long productId); 
    Optional<ProductImage> findByProductIdAndDisplayOrder(Long productId, Integer displayOrder);
    
    @Query("""
        SELECT url 
        FROM product_image 
        WHERE product_id = :productId
        ORDER BY display_order ASC
    """)
    List<ProductImageUrl> findAllImageUrlsByProductId(@Param("productId") Long productId);
}
