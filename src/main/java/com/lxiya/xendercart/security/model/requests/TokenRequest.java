package com.lxiya.xendercart.security.model.requests;

import javax.validation.constraints.NotBlank;

import com.lxiya.xendercart.core.errors.TokenErrors;

import lombok.Data;

@Data
public class TokenRequest {

    private String email;

    private String password;

    @NotBlank(message = TokenErrors.USER_TYPE_MISSING)
    private String userType;
}
