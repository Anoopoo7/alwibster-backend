/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.core;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.lxiya.xendercart.user.model.view.UserView;

import org.springframework.security.core.Authentication;

@Component
public class UserContext {

    public static UserView user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserView) {
                UserView userView = (UserView) principal;
                return userView;
            }
        }
        return new UserView();
    }

}
