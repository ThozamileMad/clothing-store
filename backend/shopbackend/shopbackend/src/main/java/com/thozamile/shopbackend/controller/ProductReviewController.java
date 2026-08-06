package com.thozamile.shopbackend.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.catalina.connector.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.thozamile.shopbackend.entity.AppUser;
import com.thozamile.shopbackend.entity.Product;
import com.thozamile.shopbackend.entity.ProductReview;
import com.thozamile.shopbackend.entity.ProductReviewCard;
import com.thozamile.shopbackend.entity.ProductReviewIsVerified;
import com.thozamile.shopbackend.entity.Sales;
import com.thozamile.shopbackend.repository.AppUserRepository;
import com.thozamile.shopbackend.repository.ProductRepository;
import com.thozamile.shopbackend.repository.ProductReviewRepository;
import com.thozamile.shopbackend.repository.SalesRepository;

@RestController
@RequestMapping("/products/reviews")
public class ProductReviewController {
    private final ProductReviewRepository productReviewRepository;
    private final AppUserRepository appUserRepository;
    private final ProductRepository productRepository;
    private final SalesRepository salesRepository;

    private ProductReviewController(
        ProductReviewRepository productReviewRepository,
        AppUserRepository appUserRepository,
        ProductRepository productRepository,
        SalesRepository salesRepository
    ) {
        this.productReviewRepository = productReviewRepository;
        this.appUserRepository = appUserRepository;
        this.productRepository = productRepository;
        this.salesRepository = salesRepository;
    }
    
    @GetMapping("/{requestedId}")
    private ResponseEntity<ProductReview> findById(@PathVariable Long requestedId) {
        Optional<ProductReview> productReview = productReviewRepository.findById(requestedId);
        if (productReview.isPresent()) {
            return ResponseEntity.ok(productReview.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/product_id/{requestedProductId}")
    private ResponseEntity<ProductReview> findByProductId(@PathVariable Long requestedProductId) {
        List<ProductReview> productReviews = productReviewRepository.findByProductId(requestedProductId);
        if (!productReviews.isEmpty()) {
            return ResponseEntity.ok(productReviews.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /* 
    @GetMapping("/user_id/{requestedUserId}")
    private ResponseEntity<ProductReview> getProductReviewByUserId(@PathVariable Long requestedUserId) {
        List<ProductReview> productReviews = productReviewRepository.findByUserId(requestedUserId);
        if (productReviews.isEmpty()) {
            return ResponseEntity.ok(productReviews.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    */

    @GetMapping("/random")
    private ResponseEntity<List<ProductReviewCard>> getAllProductReviewsRandomly(Pageable pageable) {
        Integer size = pageable.getPageSize();
        List<ProductReview> productReviews = productReviewRepository.findAllOrderByRandomByDistinct(size);

        if (productReviews.isEmpty()) {
            return ResponseEntity.notFound().build();
        } 

        List<ProductReviewCard> productReviewCards = new ArrayList<>();
        for (ProductReview pr : productReviews) {
            Optional<AppUser> user = appUserRepository.findById(pr.userId());
            Optional<Product> product = productRepository.findById(pr.productId());
            
            if (
                !user.isPresent() ||
                !product.isPresent()
            ) {
                return ResponseEntity.notFound().build();
            }

            productReviewCards.add(new ProductReviewCard(
                pr.id(),
                pr.rating(),
                user.get().firstName(),
                user.get().lastName(),
                null,
                pr.comment(),
                null,
                product.get().name()
            ));
        }

        return ResponseEntity.ok(productReviewCards); 
    }

    @GetMapping
    private ResponseEntity<List<ProductReviewCard>> getAllProductReviewsIsVerified(
        @RequestParam(name = "latest", defaultValue = "true") Boolean latest,
        @RequestParam(name = "is_verified", defaultValue = "random") String isVerified,
        @RequestParam(name = "limit", defaultValue="6") Integer limit
    ) {

        List<ProductReviewIsVerified> productReviews = new ArrayList<>();

        if (latest && isVerified.equalsIgnoreCase("true")) {
            productReviews = 
                productReviewRepository
                    .findAllIsVerifiedOrderByCreatedAtDesc(
                        true, 
                        limit
                    );
        }
        else if (!latest && isVerified.equalsIgnoreCase("false")) {
            productReviews = 
                productReviewRepository
                    .findAllIsVerifiedOrderByCreatedAtAsc(
                        false, 
                        limit
                    );
        }
        else if (!latest) {
            productReviews = 
                productReviewRepository
                    .findAllOrderByCreatedAtDesc(limit);
        }
        else {
            productReviews = 
                productReviewRepository
                    .findAllOrderByCreatedAtAsc(limit);
        }

        if (productReviews.isEmpty()) {
            return ResponseEntity.notFound().build();
        } 

        List<ProductReviewCard> productReviewCards = new ArrayList<>();
        for (ProductReviewIsVerified pr : productReviews) {
            Optional<AppUser> user = appUserRepository.findById(pr.userId());
            
            if (!user.isPresent()) {
                productReviewCards.add(new ProductReviewCard(
                    pr.id(),
                    pr.rating(),
                    null,
                    null,
                    pr.isVerified(),
                    pr.comment(),
                    pr.createdAt(),
                    null
                ));
                continue;
            }

            productReviewCards.add(new ProductReviewCard(
                pr.id(),
                pr.rating(),
                user.get().firstName(),
                user.get().lastName(),
                pr.isVerified(),
                pr.comment(),
                pr.createdAt(),
                null
            ));
        }

        return ResponseEntity.ok(productReviewCards); 
    }
    
    @PostMapping
    private ResponseEntity<Void> createProductReview(
        @RequestBody ProductReview newProductReviewRequest, 
        UriComponentsBuilder ucb
    ) {
        ProductReview savedProductReview = productReviewRepository.save(newProductReviewRequest);
        URI locationOfNewProductReview = ucb
            .path("products/reviews/{id}")
            .buildAndExpand(savedProductReview.id())
            .toUri();
        return ResponseEntity.created(locationOfNewProductReview).build();
    }
}
