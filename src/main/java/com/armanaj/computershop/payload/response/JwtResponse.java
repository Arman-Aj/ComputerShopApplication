package com.armanaj.computershop.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class JwtResponse {
    @Getter
    @Setter
    private String accessToken;

    @Getter
    @Setter
    private String tokenType = "Bearer";
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String email;
    @Getter
    private final List<String> roles;

    public JwtResponse(String accessToken, Integer id, String username, String email, List<String> roles) {
        this.accessToken = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}