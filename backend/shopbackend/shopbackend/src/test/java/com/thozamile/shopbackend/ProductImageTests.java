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
        Number productId = documentContext.read("$.product_id");
        String url = documentContext.read("url");
        Number displayOrder = documentContext.read("$.display_order");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        assertThat(url).isEqualTo("www.image.jpg");
        assertThat(displayOrder).isEqualTo(1);
    }

    @Test 
    void getProductImageByProductId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/images/product_id/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number productId = documentContext.read("$.product_id");
        String url = documentContext.read("url");
        Number displayOrder = documentContext.read("$.display_order");

        assertThat(id).isEqualTo(1);
        assertThat(productId).isEqualTo(1);
        assertThat(url).isEqualTo("www.image.jpg");
        assertThat(displayOrder).isEqualTo(1);
    }
}
