/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.security.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alwibster.backend.core.constances.TokenConstance;
import com.alwibster.backend.core.errors.TokenErrors;
import com.alwibster.backend.organization.model.constants.RoleConstances;
import com.alwibster.backend.organization.service.OrganizationService;
import com.alwibster.backend.security.model.requests.RefreshTokenRequest;
import com.alwibster.backend.security.model.requests.TokenRequest;
import com.alwibster.backend.security.model.views.AutherizedUser;
import com.alwibster.backend.security.model.views.TokenData;
import com.alwibster.backend.security.model.views.TokenView;
import com.alwibster.backend.security.service.TokenService;
import com.alwibster.backend.security.utils.JwtUtils;
import com.alwibster.backend.user.model.view.UserView;
import com.alwibster.backend.user.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserService userService;
    @Autowired
    private OrganizationService organizationService;

    private UserView createAnonymousUser(final String id) {
        UserView userView = new UserView();
        userView.setId(id != null ? id : UUID.randomUUID().toString());
        userView.setAnonymous(true);
        userView.setRole(RoleConstances.anonymous);
        return userView;
    }

    @Override
    public TokenView createToken(final TokenRequest tokenRequest) {
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
            throw new RuntimeException(TokenErrors.UNAUTHERIZED);
        }
        String accessToken = JwtUtils.generateToken(userView, TokenConstance.access);
        String refreshToken = JwtUtils.generateToken(userView, TokenConstance.refresh);
        String permissions = organizationService.getPermissionsByRoles(userView.getRole()).toString();
        return new TokenView(accessToken, refreshToken, permissions);
    }

    @Override
    public AutherizedUser findAutherizedUser(final TokenData tokenData) {
        AutherizedUser autherizedUser = new AutherizedUser();
        if (tokenData.isAnnonymus()) {
            UserView userView = this.createAnonymousUser(tokenData.getUserId());
            autherizedUser.setUser(userView);
            List<String> permissions = organizationService.getPermissionsByRoles(userView.getRole());
            autherizedUser.setRoles(permissions);
            return autherizedUser;
        }
        UserView userView = userService.getUser(tokenData.getUserId());
        if (null != userView) {
            autherizedUser.setUser(userView);
            List<String> permissions = organizationService.getPermissionsByRoles(userView.getRole());
            autherizedUser.setRoles(permissions);
            return autherizedUser;
        }
        throw new RuntimeException(TokenErrors.UNAUTHERIZED);
    }

    @Override
    public TokenView refreshToken(final RefreshTokenRequest refreshTokenRequest) {
        String token = refreshTokenRequest.getRefresh();
        if (!JwtUtils.validateToken(token)) {
            log.error("F73EC781-2FEF-4DED-B22A-D815DE37A917 Invalid token");
            throw new RuntimeException(TokenErrors.TOKEN_INVALID);
        }
        TokenData tokenData = JwtUtils.decriptToken(token);
        AutherizedUser autherizedUser = this.findAutherizedUser(tokenData);
        UserView userView = autherizedUser.getUser();
        log.info("2271027D-DB5D-42B0-BF3C-1AD2870F4EA1 creating token for user : {}", userView.getId());
        String accessToken = JwtUtils.generateToken(userView, TokenConstance.access);
        String refreshToken = JwtUtils.generateToken(userView, TokenConstance.refresh);
        String permissions = organizationService.getPermissionsByRoles(userView.getRole()).toString();
        return new TokenView(accessToken, refreshToken, permissions);
    }

}
