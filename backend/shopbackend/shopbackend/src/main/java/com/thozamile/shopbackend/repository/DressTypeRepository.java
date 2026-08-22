package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.DressType;

public interface DressTypeRepository extends CrudRepository<DressType, Long> {

    @Query("SELECT id FROM dress_type")
    List<Long> findAllIds();
    
}
