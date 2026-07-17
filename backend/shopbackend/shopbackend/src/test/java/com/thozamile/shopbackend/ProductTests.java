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
class ProductTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void getProduct() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number styleId = documentContext.read("$.style_id");
        Number typeId = documentContext.read("$.type_id");
        String name = documentContext.read("$.name");
        Double price = documentContext.read("$.price");
        String description = documentContext.read("$.description");
        
        assertThat(id).isEqualTo(1);
        assertThat(styleId).isEqualTo(1);
        assertThat(typeId).isEqualTo(1);
        assertThat(name).isEqualTo("Baggy Jeans");
        assertThat(price).isEqualTo(37.99);
        assertThat(description).isEqualTo("Simple Baggy Jeans.");
	}

    void getNonExistingProduct() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/2", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isEmpty();
    }

}
