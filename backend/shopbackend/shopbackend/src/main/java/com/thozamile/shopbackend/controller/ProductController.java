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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thozamile.shopbackend.entity.ProductCard;
import com.thozamile.shopbackend.entity.ProductColor;
import com.thozamile.shopbackend.entity.ProductDetailedCard;
import com.thozamile.shopbackend.entity.Product;
import com.thozamile.shopbackend.entity.ProductImage;
import com.thozamile.shopbackend.entity.ProductImageUrl;
import com.thozamile.shopbackend.entity.ProductRatingSummary;
import com.thozamile.shopbackend.entity.ProductSize;
import com.thozamile.shopbackend.entity.ProductVariant;
import com.thozamile.shopbackend.repository.ProductImageRepository;
import com.thozamile.shopbackend.repository.ProductRepository;
import com.thozamile.shopbackend.repository.ProductReviewRepository;
import com.thozamile.shopbackend.repository.ProductVariantRepository;
import com.thozamile.shopbackend.utility.dto.FilteredRequest;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductReviewRepository productReviewRepository;
    private final ProductVariantRepository productVariantRepository;

    private ProductController(
        ProductRepository productRepository, 
        ProductImageRepository productImageRepository,
        ProductReviewRepository productReviewRepository,
        ProductVariantRepository productVariantRepository
    ) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.productReviewRepository = productReviewRepository;
        this.productVariantRepository = productVariantRepository;
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
    

    @GetMapping("/detailed/{requestedId}")
    private ResponseEntity<ProductDetailedCard> getDetailedProductById(@PathVariable Long requestedId) {
        Optional<Product> productOptional = productRepository.findById(requestedId);

        if (!productOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } 

        Product product = productOptional.get();

        Optional<ProductRatingSummary> ratingSummaryOptional = 
            productReviewRepository
                .findAverageRatingByProductId(product.id());
            
        List<ProductImageUrl> imageUrls = 
            productImageRepository
                .findAllImageUrlsByProductId(product.id());

        List<ProductColor> colors =
            productVariantRepository
                .findAllColorsByProductId(product.id());
            
        List<ProductSize> sizes =
            productVariantRepository
                .findAllSizesByProductId(product.id());

        List<String> mappedUrls = 
            imageUrls
                .stream()
                .map(ProductImageUrl::url)
                .toList();
        
        List<String> mappedColors = 
            colors
                .stream()
                .map(ProductColor::color)
                .toList();

        List<String> mappedSizes = 
            sizes
                .stream()
                .map(ProductSize::size)
                .toList();
        
        Double ratingSummary = 0.0;
        if (ratingSummaryOptional.isPresent()) {
            ratingSummary = ratingSummaryOptional.get().averageRating();
        }

        if (
            mappedUrls.isEmpty() ||
            mappedColors.isEmpty() ||
            mappedSizes.isEmpty()
        ) {
            return ResponseEntity.notFound().build();
        }

        ProductDetailedCard productDetailedCard = new ProductDetailedCard(
            product.id(),
            product.typeId(),
            product.name(),
            product.description(),
            product.price(),
            ratingSummary,
            mappedUrls,
            mappedColors,
            mappedSizes
        );

        return ResponseEntity.ok(productDetailedCard);
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
            Optional<ProductImage> image = 
                productImageRepository
                    .findByProductIdAndDisplayOrder(p.id(), 1);

            Optional<ProductRatingSummary> ratingSummary = 
                productReviewRepository
                    .findAverageRatingByProductId(p.id());

            productCards.add(new ProductCard(
                p.id(),
                p.name(),
                p.price(),
                image.isPresent() ? image.get().url() : null,
                ratingSummary.isPresent() ? ratingSummary.get().averageRating() : null
            ));
        }

        return ResponseEntity.ok(productCards);
    }

    @GetMapping("/top_selling")
    ResponseEntity<List<ProductCard>> getTopSellingProducts(Pageable pageable) {
        List<Product> products = productRepository.findAllByOrderByRevenueDesc(
            PageRequest.of(0, 3)
        );

        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        } 

        List<ProductCard> productCards = new ArrayList<>();
        for (Product p : products) {
            Optional<ProductImage> image = 
                productImageRepository
                    .findByProductIdAndDisplayOrder(p.id(), 1);
            
            Optional<ProductRatingSummary> ratingSummary = 
                productReviewRepository
                    .findAverageRatingByProductId(p.id());

            productCards.add(new ProductCard(
                p.id(),
                p.name(),
                p.price(),
                image.isPresent() ? image.get().url() : null,
                ratingSummary.isPresent() ? ratingSummary.get().averageRating() : null
            ));
        }

        return ResponseEntity.ok(productCards);
    }

    @GetMapping("/related_products/{typeId}")
    ResponseEntity<List<ProductCard>> getRelatedProducts(@PathVariable Integer typeId) {
        List<Product> products = productRepository.findRandomByTypeId(typeId, 4);

        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        } 

        List<ProductCard> productCards = new ArrayList<>();
        for (Product p : products) {
            Optional<ProductImage> image = 
                productImageRepository
                    .findByProductIdAndDisplayOrder(p.id(), 1);
            
            Optional<ProductRatingSummary> ratingSummary = 
                productReviewRepository
                    .findAverageRatingByProductId(p.id());

            productCards.add(new ProductCard(
                p.id(),
                p.name(),
                p.price(),
                image.isPresent() ? image.get().url() : null,
                ratingSummary.isPresent() ? ratingSummary.get().averageRating(): null
            ));
        }

        return ResponseEntity.ok(productCards);
    }

    @GetMapping("/filtered") 
    ResponseEntity<List<ProductCard>> getFilteredProducts(
        @RequestParam(required = false)  List<Long> typeIds,
        @RequestParam(required = false)  List<Long> styleIds,
        @RequestParam(required = false)  List<String> colors,
        @RequestParam(required = false)  List<String> sizes,
        @RequestParam(required = false)  Integer minPrice,
        @RequestParam(required = false)  Integer maxPrice,
        @RequestParam(required = false, defaultValue = "desc")  String dateOrder
    ) {

        List<Product> products = 
            productRepository
                .findFilteredProducts(
                    typeIds, 
                    styleIds, 
                    minPrice, 
                    maxPrice, 
                    dateOrder
                );

        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ProductCard> productCards = new ArrayList<>();
        for (Product p : products) {
            Optional<ProductImage> image = 
                productImageRepository
                    .findByProductIdAndDisplayOrder(p.id(), 1);

            Optional<ProductRatingSummary> ratingSummary = 
                productReviewRepository
                    .findAverageRatingByProductId(p.id());

            List<ProductColor> productColors =
                productVariantRepository
                    .findAllColorsByProductId(p.id());
            
            List<ProductSize> productSizes =
                productVariantRepository
                    .findAllSizesByProductId(p.id());

            List<String> mappedColors = 
                productColors
                    .stream()
                    .map(ProductColor::color)
                    .toList();

            List<String> mappedSizes = 
                productSizes
                    .stream()
                    .map(ProductSize::size)
                    .toList();

            Boolean hasColor = 
                mappedColors
                    .stream()
                    .anyMatch(colors::contains);

            Boolean hasSize = 
                mappedSizes
                    .stream()
                    .anyMatch(sizes::contains);

            if (hasColor && hasSize) {
                productCards.add(new ProductCard(
                    p.id(),
                    p.name(),
                    p.price(),
                    image.isPresent() ? image.get().url() : null,
                    ratingSummary.isPresent() ? ratingSummary.get().averageRating(): null
                ));
            }
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
