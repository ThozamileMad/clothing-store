package com.thozamile.shopbackend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.thozamile.shopbackend.entity.Product;
import com.thozamile.shopbackend.entity.ProductImage;

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
public class ProductImageTests {
    @Autowired 
    TestRestTemplate restTemplate;

    @Test 
    void getProductImageById() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/images/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.productId");
        String url = documentContext.read("url");
        Number displayOrder = documentContext.read("$.displayOrder");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        assertThat(url).isEqualTo("https://example.com/images/baggy-jeans-1.jpg");
        assertThat(displayOrder).isEqualTo(1);
    }

    @Test 
    void getProductImageByProductId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/images/product_id/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.productId");
        String url = documentContext.read("url");
        Number displayOrder = documentContext.read("$.displayOrder");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        assertThat(url).isEqualTo("https://example.com/images/baggy-jeans-1.jpg");
        assertThat(displayOrder).isEqualTo(1);
    }

    @Test
    void createProductImage() {
        ProductImage newProductImage = new ProductImage(
            null, 
            1L,
            "https://example.com/images/flamingo-shirt-1.jpg",
            1
        );
        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/products/images", newProductImage, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI location = createResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(location, String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);   
    }
}
