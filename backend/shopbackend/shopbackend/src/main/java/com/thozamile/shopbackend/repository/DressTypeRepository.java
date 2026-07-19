package com.thozamile.shopbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.DressType;

public interface DressTypeRepository extends CrudRepository<DressType, Long> {
    
}
