package com.thozamile.shopbackend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.thozamile.shopbackend.entity.ProductVariant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

@AutoConfigureTestRestTemplate
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductVariantTests {
    @Autowired 
    TestRestTemplate restTemplate;

    //@Test 
    void getProductVariantById() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/variants/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.productId");
        String color = documentContext.read("$.color");
        String size = documentContext.read("$.size");
        Number stock = documentContext.read("$.stock");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        assertThat(color).isEqualTo("Blue");
        assertThat(size).isEqualTo("M");
        assertThat(stock).isEqualTo(15);
    }

    //@Test 
    void getProductVariantByProductId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/variants/product_id/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.productId");
        String color = documentContext.read("$.color");
        String size = documentContext.read("$.size");
        Number stock = documentContext.read("$.stock");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        assertThat(color).isEqualTo("Blue");
        assertThat(size).isEqualTo("M");
        assertThat(stock).isEqualTo(15);
    }

    //@Test
    void createProductVariant() {
        ProductVariant newProductVariant = new ProductVariant(
            null, 
            1L, 
            "Purple", 
            "XL", 
            50
        );
        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/products/variants", newProductVariant, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI location = createResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(location, String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);   
    }
}

