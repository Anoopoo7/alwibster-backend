/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.security.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.alwibster.backend.core.constances.TokenConstance;
import com.alwibster.backend.security.model.views.TokenData;
import com.alwibster.backend.user.model.view.UserView;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    private static String SECRET_KEY = "NTEzMEVCMDctRUI3NC00MzlBLTlCNEEtN0NEMEEyOTQyNjFC";

    private static Date expire(String type) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, type.equals(TokenConstance.refresh) ? 60 : 60);
        return calendar.getTime();
    }

    public static String generateToken(UserView userView, String tokenType) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .claim("email", userView.getEmail())
                .claim("userId", userView.getId())
                .claim("annonymus", userView.isAnonymous())
                .claim("tokenType", tokenType)
                .setExpiration(expire(tokenType))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static boolean validateToken(String token) {
        try {
            Claims decriptedData = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return !decriptedData.getExpiration().before(new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            return false;
        }
    }

    public static TokenData decriptToken(String token) {
        Jws<Claims> decriptedData = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        Claims claims = decriptedData.getBody();
        String email = (String) claims.get("email");
        String userId = (String) claims.get("userId");
        boolean annonymus = (boolean) claims.get("annonymus");
        String tokenType = (String) claims.get("tokenType");
        TokenData tokenData = new TokenData(email, userId, annonymus, tokenType);
        return tokenData;
    }
}
