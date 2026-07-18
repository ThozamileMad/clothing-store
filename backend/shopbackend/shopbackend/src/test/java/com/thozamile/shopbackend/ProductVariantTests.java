package com.thozamile.shopbackend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestRestTemplate
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductVariantTests {
    @Autowired 
    TestRestTemplate restTemplate;

    @Test 
    void getProductVariantById() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/variants/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.product_id");
        String color = documentContext.read("$.color");
        String size = documentContext.read("$.size");
        Number stock = documentContext.read("$.stock");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        assertThat(color).isEqualTo("white");
        assertThat(size).isEqualTo("S");
        assertThat(stock).isEqualTo(20);
    }

    @Test 
    void getProductVariantByProductId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/variants/product_id/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.product_id");
        String color = documentContext.read("$.color");
        String size = documentContext.read("$.size");
        Number stock = documentContext.read("$.stock");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        assertThat(color).isEqualTo("white");
        assertThat(size).isEqualTo("S");
        assertThat(stock).isEqualTo(20);
    }
}
