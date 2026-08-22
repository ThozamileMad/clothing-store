package com.thozamile.shopbackend.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.thozamile.shopbackend.entity.DressStyle;

public interface DressStyleRepository extends CrudRepository<DressStyle, Long>, PagingAndSortingRepository<DressStyle, Long> {

    @Query("SELECT id FROM dress_style")
    List<Long> findAllIds();

}
