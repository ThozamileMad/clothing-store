package com.thozamile.shopbackend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.Sales;

public interface SalesRepository extends CrudRepository<Sales, Long> {
    Optional<Sales> findByUserIdAndProductId(Long userId, Long productId);
}
