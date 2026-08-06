package com.thozamile.shopbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
    private ResponseEntity<DressStyle> getDressStyleById(@PathVariable Long requestedId) {
        Optional<DressStyle> dressStyle = dressStyleRepository.findById(requestedId);
        if (dressStyle.isPresent()) {
            return ResponseEntity.ok(dressStyle.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    private ResponseEntity<List<DressStyle>> getAllDressStyles(Pageable pageable) {
        Page<DressStyle> dressStyles = dressStyleRepository.findAll(
            PageRequest.of(
                pageable.getPageNumber(), 
                pageable.getPageSize(),
                pageable.getSortOr(
                    Sort.by(
                        Sort.Direction.ASC,
                        "id"
                    )
                )
            )
        );

        return ResponseEntity.ok(dressStyles.getContent());

    }

    @PostMapping 
    private ResponseEntity<Void> createDressStyle(
        @RequestBody DressStyle dressStyleRequest, 
        UriComponentsBuilder ucb
    ) {
        DressStyle newDressStyle = dressStyleRepository.save(dressStyleRequest);
        URI locationOfNewDressStyle = ucb
            .path("dress_styles/{id}")
            .buildAndExpand(newDressStyle.id())
            .toUri();
        return ResponseEntity.created(locationOfNewDressStyle).build();
    }
}
