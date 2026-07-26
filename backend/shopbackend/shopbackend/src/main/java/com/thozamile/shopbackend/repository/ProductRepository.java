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
            name, 
            price,
            description
        FROM product
        ORDER BY p.created_at DESC
    """)
    List<Product> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
