package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.ProductVariant;

public interface ProductVariantRepository extends CrudRepository<ProductVariant, Long> {
    List<ProductVariant> findByProductId(Long productId);
}   
