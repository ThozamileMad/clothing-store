package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.Sales;

public interface SalesRepository extends CrudRepository<Sales, Long> {
   
}
