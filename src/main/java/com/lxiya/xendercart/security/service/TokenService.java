/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.security.service;

import com.lxiya.xendercart.security.model.requests.RefreshTokenRequest;
import com.lxiya.xendercart.security.model.requests.TokenRequest;
import com.lxiya.xendercart.security.model.views.AutherizedUser;
import com.lxiya.xendercart.security.model.views.TokenData;
import com.lxiya.xendercart.security.model.views.TokenView;

public interface TokenService {

    TokenView createToken(final TokenRequest tokenRequest);

    AutherizedUser findAutherizedUser(final TokenData tokenData);

    TokenView refreshToken(final RefreshTokenRequest refreshTokenRequest);

}
