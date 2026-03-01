package com.estoque.realcar.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public String login(String username, String password) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username, password
                )
        );
        var userDetails = userDetailsService.loadUserByUsername(username);

        return jwtService.generateToken(user);
    }
}
