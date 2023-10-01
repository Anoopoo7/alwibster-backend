package com.alwibster.backend.security.model.requests;

import javax.validation.constraints.NotBlank;

import com.alwibster.backend.core.errors.TokenErrors;

import lombok.Data;

@Data
public class RefreshTokenRequest {

    @NotBlank(message = TokenErrors.TOKEN_NOT_FOUND)
    private String refresh;
}
