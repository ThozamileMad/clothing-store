package com.thozamile.shopbackend.controller;

import org.apache.catalina.connector.Response;
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

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.thozamile.shopbackend.entity.Product;
import com.thozamile.shopbackend.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    private ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{requestedId}")
    private ResponseEntity<Product> getProductById(@PathVariable Long requestedId) {
        Optional<Product> productOptional = productRepository.findById(requestedId);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAllProducts(Pageable pageable) {
        Page<Product> page = productRepository.findAll(
            PageRequest.of(
                pageable.getPageNumber(), 
                pageable.getPageSize(),
                //pageable.getSort()
                pageable.getSortOr(
                    Sort.by(
                        Sort.Direction.ASC, 
                        "id"
                    )
                )
            )
        );
        return ResponseEntity.ok(page.getContent());
    }

    @PostMapping
    private ResponseEntity<Void> createProduct(
        @RequestBody Product newProductRequest, 
        UriComponentsBuilder ucb
    ) {
        Product savedProduct = productRepository.save(newProductRequest);
        URI locationOfNewProduct = ucb
            .path("products/{id}")
            .buildAndExpand(savedProduct.id())
            .toUri();
        return ResponseEntity.created(locationOfNewProduct).build();
    }
}
