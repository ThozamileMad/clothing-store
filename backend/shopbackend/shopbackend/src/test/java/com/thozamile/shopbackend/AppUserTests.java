package com.thozamile.shopbackend;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.thozamile.shopbackend.entity.AppUser;

@AutoConfigureTestRestTemplate
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AppUserTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void isAuthenticated() {
        ResponseEntity<String> response = 
            restTemplate
                .getForEntity(
                    "/users/is_authenticated", 
                    String.class
                );
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }    

    @Test
    void signUp() {
        AppUser newAppUser = new AppUser(
            4L, 
            "ThozamileMadela", 
            "thozamile.madela@example.com", 
            "ThozamileMadela@2"
        );

        ResponseEntity<Void> postResponse = 
            restTemplate
                .postForEntity(
                    "users/sign_up", 
                    newAppUser, 
                    Void.class
                );
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI locationOfAppUser = postResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = 
            restTemplate
                .getForEntity(
                    locationOfAppUser, 
                    String.class
                );
       assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DirtiesContext
    void signIn() {
        AppUser newAppUser = new AppUser(
            null, 
            null, 
            "thabo.nkosi@example.com", 
            "$2a$10$examplehashvalUe1"
        );

        ResponseEntity<String> postResponse = 
            restTemplate
                .postForEntity(
                    "users/sign_in", 
                    newAppUser, 
                    String.class
                );
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
}
