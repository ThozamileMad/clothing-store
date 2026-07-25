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
            p.id
            p.name,
            p.price,
            p.description,
            p.created_at,
            pv.color,
            pv.size,
            pv.stock,
            pi.url,
            pi.display_order,
            pr.user_id,
            pr.rating,
            pr.comment,
            s.quantity,
            s.unit_price,
            s.total_price,
            s.sold_at,
        FROM product p
        JOIN product_variant pv ON pv.product_id = p.id
        JOIN product_image pi ON pi.product_id = p.id
        JOIN product_review pv ON pr.product_id = p.id
        JOIN sale s pv ON s.product_id = p.id
        GROUP BY p.id
        ORDER BY created_at ASC
            
    """
    )
    List<Product> findAllByOrderByCreatedAtAsc(Pageable pageable);
    //List<Product> findByOrderByPriceAsc(Pageable pageable);
    
    @Query("""
        SELECT 
            p.id AS r
    """)
    List<Product> findAllByOrderByRevenueDesc(Pageable pageable);
}
