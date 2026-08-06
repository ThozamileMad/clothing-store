package com.thozamile.shopbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.thozamile.shopbackend.entity.DressStyle;

public interface DressStyleRepository extends CrudRepository<DressStyle, Long>, PagingAndSortingRepository<DressStyle, Long> {
}
