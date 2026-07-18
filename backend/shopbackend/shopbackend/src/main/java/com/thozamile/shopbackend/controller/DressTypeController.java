package com.thozamile.shopbackend.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thozamile.shopbackend.example.DressType;

@RestController
@RequestMapping("/dress_types")
public class DressTypeController {

    @GetMapping("/{requestedId}")
    private ResponseEntity<DressType> getDressTypeById(@PathVariable Long requestedId) {
        if (requestedId == null) {
            return ResponseEntity.notFound().build();
        }
        
        DressType DressType = new DressType(
            requestedId, 
            "pants"
        );

        return ResponseEntity.ok(DressType);
    }
}
