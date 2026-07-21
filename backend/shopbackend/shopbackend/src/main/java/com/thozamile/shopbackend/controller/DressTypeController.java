package com.thozamile.shopbackend.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thozamile.shopbackend.entity.DressType;
import com.thozamile.shopbackend.repository.DressTypeRepository;

@RestController
@RequestMapping("/dress_types")
public class DressTypeController {
    private final DressTypeRepository dressTypeRepository;

    private DressTypeController(DressTypeRepository dressTypeRepository) {
        this.dressTypeRepository = dressTypeRepository;
    }

    @GetMapping("/{requestedId}")
    private ResponseEntity<DressType> getDressType(@PathVariable Long requestedId) {
        Optional<DressType> dressType = dressTypeRepository.findById(requestedId);
        if (dressType.isPresent()) {
            return ResponseEntity.ok(dressType.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createDressType(
        @RequestBody DressType dressTypeRequest,
        UriComponentsBuilder ucb
    ) {
        DressType newDressType = dressTypeRepository.save(dressTypeRequest);
        URI locationOfNewDressType = ucb
            .path("/dress_types/{id}")
            .buildAndExpand(newDressType.id())
            .toUri();
        return ResponseEntity.created(locationOfNewDressType).build();
    }
}
