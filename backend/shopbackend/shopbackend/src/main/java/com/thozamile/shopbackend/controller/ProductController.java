package com.thozamile.shopbackend.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thozamile.shopbackend.entity.Product;
import com.thozamile.shopbackend.entity.ProductCard;
import com.thozamile.shopbackend.entity.ProductImage;
import com.thozamile.shopbackend.entity.ProductRatingSummary;
import com.thozamile.shopbackend.entity.ProductReview;
import com.thozamile.shopbackend.entity.ProductWithRevenue;
import com.thozamile.shopbackend.repository.ProductImageRepository;
import com.thozamile.shopbackend.repository.ProductRepository;
import com.thozamile.shopbackend.repository.ProductReviewRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductReviewRepository productReviewRepository;

    private ProductController(
        ProductRepository productRepository, 
        ProductImageRepository productImageRepository,
        ProductReviewRepository productReviewRepository
    ) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.productReviewRepository = productReviewRepository;
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

    @GetMapping("/new_arrivals")
    ResponseEntity<List<ProductCard>> getNewProducts() {
        List<Product> products = productRepository.findAllByOrderByCreatedAtDesc(
            PageRequest.of(0, 3)
        );

        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        } 
        List<ProductCard> productCards = new ArrayList<>();
        for (Product p : products) {
            List<ProductImage> images = productImageRepository.findAllByProductId(p.id());
            ProductRatingSummary ratingSummary = productReviewRepository.findAllByAverageRating(p.id());

            productCards.add(new ProductCard(
                p, 
                null,
                ratingSummary, 
                images, 
                null,
                null, 
                null, 
                null
            ));
        }

        return ResponseEntity.ok(productCards);
    }

    @GetMapping("/top_selling")
    ResponseEntity<List<ProductCard>> getTopSellingProducts(Pageable pageable) {
        List<ProductWithRevenue> products = productRepository.findAllByOrderByRevenueDesc(
            PageRequest.of(0, 3)
        );

        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        } 

        List<ProductCard> productCards = new ArrayList<>();
        for (ProductWithRevenue p : products) {
            List<ProductImage> images = productImageRepository.findAllByProductId(p.id());
            ProductRatingSummary ratingSummary = productReviewRepository.findAllByAverageRating(p.id());

            productCards.add(new ProductCard(
                null, 
                p,
                ratingSummary, 
                images, 
                null,
                null, 
                null, 
                null
            ));
        }

        return ResponseEntity.ok(productCards);
    }

    /* 
    


    @PostMapping
    private ResponseEntity<Void> save(
        @RequestBody Product newProductRequest, 
        UriComponentsBuilder ucb
    ) {
        Product savedProduct = productRepository.save(newProductRequest);
        URI locationOfNewProduct = ucb
            .path("products/{id}")
            .buildAndExpand(savedProduct.id())
            .toUri();
        return ResponseEntity.created(locationOfNewProduct).build();
    }*/
}
