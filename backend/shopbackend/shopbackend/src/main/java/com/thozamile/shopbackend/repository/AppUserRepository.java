package com.thozamile.shopbackend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.thozamile.shopbackend.entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
