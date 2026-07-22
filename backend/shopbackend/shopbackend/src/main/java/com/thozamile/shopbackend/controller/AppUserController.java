package com.thozamile.shopbackend.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thozamile.shopbackend.entity.AppUser;
import com.thozamile.shopbackend.repository.AppUserRepository;

@RestController
@RequestMapping("/users")
public class AppUserController {
    private AppUserRepository appUserRepository;

    private AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/is_authenticated")
    private ResponseEntity<AppUser> isAuthenticated() {
        Optional<AppUser> currentUser = appUserRepository.findById(1L);

        if (currentUser.isPresent()) {
            return ResponseEntity.ok(currentUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/sign_up")
    private ResponseEntity<Void> signUp(
        @RequestBody AppUser appUserRequest,
        UriComponentsBuilder ucb
    ) {        

        // Null Check

        if (appUserRequest == null) {
            return ResponseEntity.badRequest().build();
        }
        
        String providedUsername = appUserRequest.username();
        String providedEmail = appUserRequest.email();
        String providedPasswordHash = appUserRequest.passwordHash();

        if (
            providedUsername == null ||
            providedEmail == null ||
            providedPasswordHash == null 
        ) {
            return ResponseEntity.badRequest().build();
        }

        providedUsername = providedUsername.trim();
        providedEmail = providedEmail.trim();
        providedPasswordHash = providedPasswordHash.trim();

        // Emptiness Check

        if (
            providedUsername.isBlank() ||
            providedEmail.isBlank() ||
            providedPasswordHash.isBlank()
        ) {
            return ResponseEntity.badRequest().build();
        }

        // Character Check

        if (
            !providedUsername.matches("^[A-Za-z\\d]+$") ||
            !providedEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") ||
            !(
                providedPasswordHash.matches(".*[A-Z].*") &&
                providedPasswordHash.matches(".*[a-z].*") &&
                providedPasswordHash.matches(".*[\\d].*") &&
                providedPasswordHash.matches(".*[\\W].*") 
            )
        ) {
            return ResponseEntity.badRequest().build();
        }

        // Length Check

        if (
            (
                providedUsername.length() <= 5 && 
                providedUsername.length() > 255
            ) 
              ||
                providedEmail.length() > 255 
              ||
            (
                providedPasswordHash.length() <= 8 && 
                providedPasswordHash.length() > 255
            )
        ) {
            return ResponseEntity.badRequest().build();
        }

        // DB Match Check

        Optional<AppUser> existingUser = appUserRepository.findByEmail(providedEmail);

        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        // Authentication 

        AppUser newAppUser = appUserRepository.save(appUserRequest);

        // authenticate() // non-existing function stores generated auth token

        URI newAppUserLocation = ucb
            .path("/users/is_authenticated")
            .buildAndExpand(newAppUser.id())
            .toUri();

        return ResponseEntity.created(newAppUserLocation).build();
    }

    @PostMapping("/sign_in")
    private ResponseEntity<AppUser> signIn(
        @RequestBody AppUser appUserRequest,
        UriComponentsBuilder ucb
    ) {
        // Null Check

        if (appUserRequest == null) {
            return ResponseEntity.badRequest().build();
        }
        
        String providedEmail = appUserRequest.email();
        String providedPasswordHash = appUserRequest.passwordHash();

        if (providedEmail == null || providedPasswordHash == null) {
            return ResponseEntity.badRequest().build();
        }

        providedEmail = providedEmail.trim();
        providedPasswordHash = providedPasswordHash.trim();

        // Emptiness Check

        if (providedEmail.isBlank() || providedPasswordHash.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        // Character Check

        if (
            !providedEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") ||
            !(
                providedPasswordHash.matches(".*[A-Z].*") &&
                providedPasswordHash.matches(".*[a-z].*") &&
                providedPasswordHash.matches(".*[\\d].*") &&
                providedPasswordHash.matches(".*[\\W].*") 
            )
        ) {
            return ResponseEntity.badRequest().build();
        }

        // Length Check

        if (
            providedEmail.length() > 255 ||
            (
                providedPasswordHash.length() <= 8 && 
                providedPasswordHash.length() > 255
            )
        ) {
            return ResponseEntity.badRequest().build();
        }

        // DB Match Check

        Optional<AppUser> existingUser = appUserRepository.findByEmail(providedEmail);

        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    
        boolean nonExistentPasswordHash =
            !existingUser
                .get()
                .passwordHash()
                .equals(
                    providedPasswordHash
                ); 
        
        if (nonExistentPasswordHash) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // authenticate() // non-existing function stores generated auth token

        return ResponseEntity.ok(existingUser.get());
    }
}
