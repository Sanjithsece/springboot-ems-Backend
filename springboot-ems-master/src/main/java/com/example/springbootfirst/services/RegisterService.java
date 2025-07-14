package com.example.springbootfirst.services;

import com.example.springbootfirst.jwt.JwtResponseDto;
import com.example.springbootfirst.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public JwtResponseDto authenticateAndGenerateToken(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println("Generated Token: " + token); // Debug log

        return new JwtResponseDto(token, "Bearer");
    }
}
