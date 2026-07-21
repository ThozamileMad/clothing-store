package com.thozamile.shopbackend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.thozamile.shopbackend.entity.ProductReview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

@AutoConfigureTestRestTemplate
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductReviewTests {
    @Autowired 
    TestRestTemplate restTemplate;
 
    @Test 
    void getProductReviewById() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/reviews/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.productId");
        //Number userId = documentContext.read("$.user_id");
        Double rating = documentContext.read("$.rating");
        String comment = documentContext.read("$.comment");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        //assertThat(userId).isEqualTo(1);
        assertThat(rating).isEqualTo(4.5);
        assertThat(rating).isBetween(1.0, 5.0);
        assertThat(comment).isEqualTo("Great fit, very comfortable for everyday wear.");
    }

    @Test 
    void getProductReviewByProductId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/reviews/product_id/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.productId");
        //Number userId = documentContext.read("$.user_id");
        Double rating = documentContext.read("$.rating");
        String comment = documentContext.read("$.comment");


        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        //assertThat(userId).isEqualTo(1);
        assertThat(rating).isEqualTo(4.5);
        assertThat(rating).isBetween(1.0, 5.0);
        assertThat(comment).isEqualTo("Great fit, very comfortable for everyday wear.");
    }

    //@Test 
    void getProductReviewByUserId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/reviews/user_id/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.productId");
        //Number userId = documentContext.read("$.user_id");
        Double rating = documentContext.read("$.rating");
        String comment = documentContext.read("$.comment");


        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        //assertThat(userId).isEqualTo(1);
        assertThat(rating).isEqualTo(4.5);
        assertThat(rating).isBetween(1.0, 5.0);
        assertThat(comment).isEqualTo("Great fit, very comfortable for everyday wear.");
    }

    @Test
    void createProductReview() {
        ProductReview newProductReview = new ProductReview(
            null, 
            1L, 
            4.0, 
            "It's okay I guess."
        );
        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/products/reviews", newProductReview, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI location = createResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(location, String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);   
    }

}
