package com.thozamile.shopbackend.entity;

import org.springframework.data.annotation.Id;

public record AppUser(
    @Id Long id,
    String username,
    String email,
    String passwordHash
) {
    

}
