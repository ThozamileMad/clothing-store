package com.thozamile.shopbackend.entity;

import org.springframework.data.annotation.Id;

public record DressType(@Id Long id, String name) {

}
