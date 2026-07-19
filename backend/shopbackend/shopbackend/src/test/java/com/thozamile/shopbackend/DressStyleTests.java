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
class DressStyleTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void getDressStyle() {
            ResponseEntity<String> response = restTemplate.getForEntity("/dress_styles/1", String.class);
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(response.getBody()).isNotEmpty();

            DocumentContext documentContext = JsonPath.parse(response.getBody());
            Number id = documentContext.read("$.id");
            String name = documentContext.read("$.name");
            
            assertThat(id).isEqualTo(1);
            assertThat(name).isEqualTo("casual");
        }
}
