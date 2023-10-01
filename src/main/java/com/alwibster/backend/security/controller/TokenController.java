/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alwibster.backend.security.model.requests.RefreshTokenRequest;
import com.alwibster.backend.security.model.requests.TokenRequest;
import com.alwibster.backend.security.model.views.TokenView;
import com.alwibster.backend.security.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public TokenView createToken(@Valid @RequestBody final TokenRequest tokenRequest) {
        return tokenService.createToken(tokenRequest);
    }

    @PostMapping("/refresh")
    public TokenView refreshToken(@Valid @RequestBody final RefreshTokenRequest refreshTokenRequest) {
        return tokenService.refreshToken(refreshTokenRequest);
    }

}
