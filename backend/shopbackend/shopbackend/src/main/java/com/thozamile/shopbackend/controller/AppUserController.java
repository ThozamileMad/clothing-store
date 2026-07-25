package com.thozamile.shopbackend.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AppUserController(
        AppUserRepository appUserRepository, 
        PasswordEncoder passwordEncoder,
        AuthenticationManager authenticationManager
    ) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/is_authenticated")
    public ResponseEntity<AppUser> isAuthenticated() {
        Optional<AppUser> currentUser = appUserRepository.findById(1L);

        if (currentUser.isPresent()) {
            return ResponseEntity.ok(currentUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/sign_up")
    public ResponseEntity<Void> signUp(
        @RequestBody AppUser appUserRequest,
        UriComponentsBuilder ucb
    ) {        

        // Null Check

        if (appUserRequest == null) {
            return ResponseEntity.badRequest().build();
        }
        
        String providedUsername = appUserRequest.username();
        String providedEmail = appUserRequest.email();
        String providedPassword = appUserRequest.passwordHash();

        if (
            providedUsername == null ||
            providedEmail == null ||
            providedPassword == null 
        ) {
            return ResponseEntity.badRequest().build();
        }

        providedUsername = providedUsername.trim();
        providedEmail = providedEmail.trim();
        providedPassword = providedPassword.trim();

        // Emptiness Check

        if (
            providedUsername.isBlank() ||
            providedEmail.isBlank() ||
            providedPassword.isBlank()
        ) {
            return ResponseEntity.badRequest().build();
        }

        // Character Check

        if (
            !providedUsername.matches("^[A-Za-z\\d]+$") ||
            !providedEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") ||
            !(
                providedPassword.matches(".*[A-Z].*") &&
                providedPassword.matches(".*[a-z].*") &&
                providedPassword.matches(".*[\\d].*") &&
                providedPassword.matches(".*[\\W].*") 
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
                providedPassword.length() <= 8 && 
                providedPassword.length() > 255
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

        AppUser savedAppUser = new AppUser(
            null, 
            providedUsername, 
            providedEmail, 
            passwordEncoder.encode(providedPassword),
            "user"
        );
        AppUser newAppUser = appUserRepository.save(savedAppUser);

        // authenticate() // non-existing function stores generated auth token

        URI newAppUserLocation = ucb
            .path("/users/is_authenticated")
            .buildAndExpand(newAppUser.id())
            .toUri();

        return ResponseEntity.created(newAppUserLocation).build();
    }

    @PostMapping("/sign_in")
    public ResponseEntity<String> signIn(
        @RequestBody AppUser appUserRequest,
        UriComponentsBuilder ucb
    ) {
        // Null Check

        if (appUserRequest == null) {
            return ResponseEntity.badRequest().build();
        }
        
        String providedEmail = appUserRequest.email();
        String providedPassword = appUserRequest.passwordHash();

        if (providedEmail == null || providedPassword == null) {
            return ResponseEntity.badRequest().build();
        }

        providedEmail = providedEmail.trim();
        providedPassword = providedPassword.trim();

        // Emptiness Check

        if (providedEmail.isBlank() || providedPassword.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        // Character Check

        if (
            !providedEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") ||
            !(
                providedPassword.matches(".*[A-Z].*") &&
                providedPassword.matches(".*[a-z].*") &&
                providedPassword.matches(".*[\\d].*") &&
                providedPassword.matches(".*[\\W].*") 
            )
        ) {
            return ResponseEntity.badRequest().build();
        }

        // Length Check

        if (
            providedEmail.length() > 255 ||
            (
                providedPassword.length() <= 8 && 
                providedPassword.length() > 255
            )
        ) {
            return ResponseEntity.badRequest().build();
        }

        // DB Match Check

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(providedEmail, providedPassword)
            );
            return ResponseEntity.ok("Successful");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
