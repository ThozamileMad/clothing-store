package com.thozamile.shopbackend.entity;

import org.springframework.data.annotation.Id;

public record DressStyle(@Id Long id, String name) {
    
}