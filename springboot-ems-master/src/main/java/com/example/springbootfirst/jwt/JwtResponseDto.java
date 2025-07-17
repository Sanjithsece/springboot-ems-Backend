package com.example.springbootfirst.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private Set<String> roles;
    private String password;

    public void setToken(String token) {
        this.accessToken = token;
    }

    public String getToken() {
        return accessToken;
    }
}
