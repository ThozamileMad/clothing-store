package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.thozamile.shopbackend.entity.Product;

public interface ProductRepository 
    extends 
        CrudRepository<Product, Long>, 
        PagingAndSortingRepository<Product, Long> 
{
    @Query("""
        SELECT 
            id,
            name, 
            price,
            description
        FROM product
        ORDER BY created_at DESC
    """)
    List<Product> findAllByOrderByCreatedAtDesc(Pageable pageable);

    @Query("""
        SELECT 
            p.id,
            p.name, 
            p.price,
            p.description,
            COALESCE(SUM(s.total_price), 0) AS revenue
        FROM product p
        JOIN sale s ON s.product_id = p.id
        GROUP BY p.id
        ORDER BY revenue DESC
    """)
    List<Product> findAllByOrderByRevenueDesc(Pageable pageable);

    @Query("""
        SELECT *
        FROM product
        WHERE type_id = :typeId
        ORDER BY RANDOM()
        LIMIT :limit
    """)
    List<Product> findRandomByTypeId(
        @Param("typeId") Integer typeId, 
        @Param("limit") Integer limit
    );

     @Query("""
        SELECT 
            id,
            name,
            price
        FROM product
        WHERE 
            (:typeIds IS NULL OR type_id IN(:typeIds))
            AND 
            (:styleIds IS NULL OR style_id IN(:styleIds)) 
            AND
            (:minPrice IS NULL OR price >= :minPrice) 
            AND 
            (:maxPrice IS NULL OR price <= :maxPrice)
        ORDER BY 
            CASE WHEN :order = 'asc' THEN created_at END ASC,
            CASE WHEN :order = 'desc' THEN created_at END DESC
    """)
    List<Product> findFilteredProducts(
        @Param("typeIds") List<Long> typeIds, 
        @Param("styleIds") List<Long> styleIds, 
        @Param("minPrice") Integer minPrice,
        @Param("maxPrice") Integer maxPrice,
        @Param("order") String order
    );
}
