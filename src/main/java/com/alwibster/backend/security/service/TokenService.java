/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.security.service;

import com.alwibster.backend.security.model.requests.RefreshTokenRequest;
import com.alwibster.backend.security.model.requests.TokenRequest;
import com.alwibster.backend.security.model.views.AutherizedUser;
import com.alwibster.backend.security.model.views.TokenData;
import com.alwibster.backend.security.model.views.TokenView;

public interface TokenService {

    TokenView createToken(final TokenRequest tokenRequest);

    AutherizedUser findAutherizedUser(final TokenData tokenData);

    TokenView refreshToken(final RefreshTokenRequest refreshTokenRequest);

}
