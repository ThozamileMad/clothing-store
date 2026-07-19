package com.thozamile.shopbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
