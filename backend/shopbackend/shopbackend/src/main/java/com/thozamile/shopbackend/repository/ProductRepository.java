package com.thozamile.shopbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.thozamile.shopbackend.entity.Product;

public interface ProductRepository 
    extends 
        CrudRepository<Product, Long>, 
        PagingAndSortingRepository<Product, Long> 
{
    
}
