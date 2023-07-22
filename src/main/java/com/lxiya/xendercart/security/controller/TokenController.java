/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiya.xendercart.security.model.requests.TokenRequest;
import com.lxiya.xendercart.security.model.views.TokenView;
import com.lxiya.xendercart.security.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public TokenView createToken(@Valid @RequestBody TokenRequest tokenRequest) throws Exception {
        return tokenService.createToken(tokenRequest);
    }

}
