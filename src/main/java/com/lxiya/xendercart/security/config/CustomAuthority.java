/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.security.config;

import org.springframework.security.core.GrantedAuthority;

public class CustomAuthority implements GrantedAuthority {
    private String authority;

    public CustomAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
