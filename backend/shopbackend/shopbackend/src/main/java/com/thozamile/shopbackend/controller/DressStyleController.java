package com.thozamile.shopbackend.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.example.DressStyle;

@RestController
@RequestMapping("/dress_styles")
public class DressStyleController {

    @GetMapping("/{requestedId}")
    private ResponseEntity<DressStyle> getDressStyleById(@PathVariable Long requestedId) {
        if (requestedId == null) {
            return ResponseEntity.notFound().build();
        }
        
        DressStyle dressStyle = new DressStyle(
            requestedId, 
            "casual"
        );

        return ResponseEntity.ok(dressStyle);
    }
}
