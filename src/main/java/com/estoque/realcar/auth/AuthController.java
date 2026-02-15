package com.estoque.realcar.auth;

import com.estoque.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        String token = service.login(
                request.getUsername(),
                request.getPassword()
        );

        return new AuthResponse(token);
    }
}
