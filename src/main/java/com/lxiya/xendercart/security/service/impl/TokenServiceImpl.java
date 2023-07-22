/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.security.service.impl;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiya.xendercart.core.constances.TokenConstance;
import com.lxiya.xendercart.core.errors.TokenErrors;
import com.lxiya.xendercart.security.model.requests.TokenRequest;
import com.lxiya.xendercart.security.model.views.AutherizedUser;
import com.lxiya.xendercart.security.model.views.TokenData;
import com.lxiya.xendercart.security.model.views.TokenView;
import com.lxiya.xendercart.security.service.TokenService;
import com.lxiya.xendercart.security.utils.JwtUtils;
import com.lxiya.xendercart.user.model.view.UserView;
import com.lxiya.xendercart.user.service.UserService;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserService userService;

    private UserView createAnonymousUser(String id) {
        UserView userView = new UserView();
        userView.setId(id != null ? id : UUID.randomUUID().toString());
        userView.setAnonymous(true);
        return userView;
    }

    @Override
    public TokenView createToken(@Valid TokenRequest tokenRequest) throws Exception {
        String email = tokenRequest.getEmail();
        String password = tokenRequest.getPassword();
        String userType = tokenRequest.getUserType();
        UserView userView = null;
        if (userType.equals(TokenConstance.anonymous)) {
            userView = this.createAnonymousUser(null);
        } else {
            userView = userService.getUserByEmailAndPassword(email, password);
        }
        if (null == userView) {
            throw new Exception(TokenErrors.UNAUTHERIZED);
        }
        String accessToken = JwtUtils.generateToken(userView, TokenConstance.access);
        String refreshToken = JwtUtils.generateToken(userView, TokenConstance.refresh);
        return new TokenView(accessToken, refreshToken, null);
    }

    @Override
    public AutherizedUser findAutherizedUser(TokenData tokenData) {
        AutherizedUser autherizedUser = new AutherizedUser();
        if (tokenData.isAnnonymus()) {
            UserView userView = this.createAnonymousUser(tokenData.getUserId());
            autherizedUser.setUser(userView);
            return autherizedUser;
        }
        UserView userView = userService.getUser(tokenData.getUserId());
        if (null != userView) {
            autherizedUser.setUser(userView);
            return autherizedUser;
        }
        throw new RuntimeException(TokenErrors.UNAUTHERIZED);
    }

}
