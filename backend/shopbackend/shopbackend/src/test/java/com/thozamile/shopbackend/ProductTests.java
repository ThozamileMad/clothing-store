package com.thozamile.shopbackend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.thozamile.shopbackend.entity.Product;

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
class ProductTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void getProduct() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        Number styleId = documentContext.read("$.styleId");
        Number typeId = documentContext.read("$.typeId");
        String name = documentContext.read("$.name");
        Double price = documentContext.read("$.price");
        String description = documentContext.read("$.description");
        
        assertThat(id).isEqualTo(1);
        assertThat(styleId).isEqualTo(1);
        assertThat(typeId).isEqualTo(1);
        assertThat(name).isEqualTo("Baggy Jeans");
        assertThat(price).isEqualTo(80.99);
        assertThat(description).isEqualTo("Comfortable baggy fit jeans with a relaxed feel.");
	}

    @Test
    void createProduct() {
        Product newProduct = new Product(
            null, 
            1L, 
            1L, 
            "Flamingo Shirt", 
            120.00, 
            "Comfortable and colorful shirt with a relaxed feel."
        );
        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/products", newProduct, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI location = createResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(location, String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);   
    }

}
