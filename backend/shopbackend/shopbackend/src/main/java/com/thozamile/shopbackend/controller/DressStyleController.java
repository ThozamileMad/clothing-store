package com.thozamile.shopbackend.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.entity.DressStyle;
import com.thozamile.shopbackend.repository.DressStyleRepository;

@RestController
@RequestMapping("/dress_styles")
public class DressStyleController {
    private final DressStyleRepository dressStyleRepository;

    private DressStyleController(DressStyleRepository dressStyleRepository) {
        this.dressStyleRepository = dressStyleRepository;
    }

    @GetMapping("/{requestedId}")
    private ResponseEntity<DressStyle> findById(@PathVariable Long requestedId) {
        Optional<DressStyle> dressStyle = dressStyleRepository.findById(requestedId);
        if (dressStyle.isPresent()) {
            return ResponseEntity.ok(dressStyle.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
