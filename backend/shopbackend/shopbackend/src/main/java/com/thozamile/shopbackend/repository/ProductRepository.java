package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

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
}
