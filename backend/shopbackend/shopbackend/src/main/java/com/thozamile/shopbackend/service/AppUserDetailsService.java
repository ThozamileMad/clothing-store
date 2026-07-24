package com.thozamile.shopbackend.service;

import com.thozamile.shopbackend.entity.AppUser;
import com.thozamile.shopbackend.repository.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {
    
    private final AppUserRepository appUserRepository;

    public AppUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> appUser = appUserRepository.findByEmail(email);

        if (!appUser.isPresent()) {
            throw new UsernameNotFoundException("User not found: " + email);
        }

        AppUser found = appUser.get();

        return User.builder()
                .username(found.username())
                .password(found.passwordHash())
                .roles("user")
                .build();
    }
}
