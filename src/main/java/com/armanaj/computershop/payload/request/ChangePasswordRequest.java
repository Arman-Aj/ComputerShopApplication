package com.armanaj.computershop.payload.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class ChangePasswordRequest {

    @Getter
    @Setter
    @NotBlank
    private String oldPassword;

    @Getter
    @Setter
    @NotBlank
    @Length(min = 8, max = 20)
    private String newPassword;
}
