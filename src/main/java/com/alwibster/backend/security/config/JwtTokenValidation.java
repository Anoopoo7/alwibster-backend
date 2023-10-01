/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.security.config;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alwibster.backend.core.constances.TokenConstance;
import com.alwibster.backend.core.utils.StringUtils;
import com.alwibster.backend.security.model.views.AutherizedUser;
import com.alwibster.backend.security.model.views.TokenData;
import com.alwibster.backend.security.service.TokenService;
import com.alwibster.backend.security.utils.JwtUtils;
import com.alwibster.backend.security.utils.SecurityUtils;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtTokenValidation extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        if (SecurityUtils.verifyRequest(request, response, filterChain)) {
            return;
        }
        String token = SecurityUtils.extractToken(request);
        if (null == token || StringUtils.isBlank(token)) {
            log.error("30A4A60E-3EB7-436F-8B4A-8524D5D8DD21 Token not found");
            SecurityUtils.unAuthorizedResponse(response);
            return;
        }
        if (!JwtUtils.validateToken(token)) {
            log.error("B47C165F-E9BC-440A-81C5-AFF58660DBBC Invalid token");
            SecurityUtils.unAuthorizedResponse(response);
            return;
        }
        TokenData tokenData = JwtUtils.decriptToken(token);
        if (null != tokenData && TokenConstance.access.equals(tokenData.getTokenType())) {
            AutherizedUser user = tokenService.findAutherizedUser(tokenData);
            if (null != user) {
                List<GrantedAuthority> authorities = user.getRoles().stream()
                        .map(CustomAuthority::new)
                        .collect(Collectors.toList());
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        user.getUser(), authorities, authorities);
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                filterChain.doFilter(request, response);
                return;
            }
        }
        SecurityUtils.unAuthorizedResponse(response);
    }
}
