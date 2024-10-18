package com.armanaj.computershop.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    @Getter
    @Setter
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @Getter
    @Setter
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    @Getter
    @Setter
    private String password;
}