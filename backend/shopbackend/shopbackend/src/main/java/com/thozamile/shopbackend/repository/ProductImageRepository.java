package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.ProductImage;

public interface ProductImageRepository extends CrudRepository<ProductImage, Long> {
    List<ProductImage> findByProductId(Long productId); 
}
