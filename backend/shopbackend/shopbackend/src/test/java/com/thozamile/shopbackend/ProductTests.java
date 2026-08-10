package com.thozamile.shopbackend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.thozamile.shopbackend.entity.Product;

import net.minidev.json.JSONArray;

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
class ProductTests {
	@Autowired
	TestRestTemplate restTemplate;

	//@Test
	void getProduct() {
        ResponseEntity<String> response = 
            restTemplate.getForEntity("/products/1", String.class);
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

    //@Test
	void getDetailedProductById() {
        ResponseEntity<String> response = 
            restTemplate.getForEntity("/products/detailed/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

        System.out.println(response.getBody());
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

    //@Test
    //@DirtiesContext
    void createProduct() {
        Product newProduct = new Product(
            null, 
            1L,
            1L, 
            "FLamingo Shirt", 
            120.00, 
            "Just a shirt.s", 
            null, 
            null
        );

        ResponseEntity<Void> createResponse = 
            restTemplate
                .withBasicAuth("ThaboNkosi", "ThaboNkosi@2")
                .postForEntity("/products", newProduct, Void.class);
        
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI location = createResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(location, String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK); 
    }

    //@Test 
    void getAllProducts() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products?page=0&size=1&sort=id,desc", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());

        /*
        int productCount = documentContext.read("$.length()");
        assertThat(productCount).isEqualTo(1);

        JSONArray ids = documentContext.read("$..id");
        assertThat(ids).containsExactlyInAnyOrder(1, 2, 3);*/

        JSONArray page = documentContext.read("$[*]");
        assertThat(page.size()).isEqualTo(1);

        int id = documentContext.read("$.[0].id");
        assertThat(id).isEqualTo(3);
    }

    //@Test 
    void getNewProducts() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/new_arrivals", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        System.out.println(response.getBody());
        DocumentContext documentContext = JsonPath.parse(response.getBody());

        JSONArray page = documentContext.read("$[*]");
        String name = documentContext.read("$.[0].name");
        Number price = documentContext.read("$.[0].price");
        Number averageRating = documentContext.read("$.[0].averageRating");
        String imageUrl = documentContext.read("$[0].url");

        assertThat(page.size()).isEqualTo(3);
        assertThat(name).isEqualTo("Regular Denim Jacket");
        assertThat(price).isEqualTo(120.0);
        assertThat(averageRating).isEqualTo(4.0);
        assertThat(imageUrl).isEqualTo("https://example.com/images/denim-jacket-1.jpg");
    }

    //@Test 
    void getProductByRevenue() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/top_selling", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        System.out.println(response.getBody());
        
        DocumentContext documentContext = JsonPath.parse(response.getBody());

        JSONArray page = documentContext.read("$[*]");
        String name = documentContext.read("$.[2].name");
        Number price = documentContext.read("$.[2].price");
        Number averageRating = documentContext.read("$.[2].averageRating");
        String imageUrl = documentContext.read("$[2].url");

        assertThat(page.size()).isEqualTo(3);
        assertThat(name).isEqualTo("Slim Fit Tee");
        assertThat(price).isEqualTo(25.5);
        assertThat(averageRating).isEqualTo(5.0);
        assertThat(imageUrl).isEqualTo("https://example.com/images/slim-tee-1.jpg");
    }

    @Test 
    void getRelatedProducts() {
        ResponseEntity<String> response = restTemplate.getForEntity("/products/related_products/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        System.out.println(response.getBody());
    }
}
