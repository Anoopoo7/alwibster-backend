/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.security.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.lxiya.xendercart.core.constances.TokenConstance;
import com.lxiya.xendercart.security.model.views.TokenData;
import com.lxiya.xendercart.user.model.view.UserView;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    private static String SECRET_KEY = "NTEzMEVCMDctRUI3NC00MzlBLTlCNEEtN0NEMEEyOTQyNjFC";

    private static Date expire(String type) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, type.equals(TokenConstance.refresh) ? 60 : 10);
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
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
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
