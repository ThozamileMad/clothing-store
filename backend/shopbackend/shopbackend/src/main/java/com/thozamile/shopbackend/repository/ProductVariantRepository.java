package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thozamile.shopbackend.entity.ProductColor;
import com.thozamile.shopbackend.entity.ProductSize;
import com.thozamile.shopbackend.entity.ProductVariant;

public interface ProductVariantRepository extends CrudRepository<ProductVariant, Long> {
    List<ProductVariant> findByProductId(Long productId);
    List<ProductVariant> findAllByProductId(Long productId);

    @Query("""
        SELECT color 
        FROM product_variant 
        WHERE product_id = :productId
        ORDER BY color ASC
    """)
    List<ProductColor> findAllColorsByProductId(@Param("productId") Long productId);

    @Query("""
        SELECT size 
        FROM product_variant 
        WHERE product_id = :productId
    """)
    List<ProductSize> findAllSizesByProductId(@Param("productId") Long productId);

    @Query("SELECT DISTINCT color FROM product_variant")
    List<String> findAllColors();

    @Query("SELECT DISTINCT size FROM product_variant")
    List<String> findAllSizes();

}   
