/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.security.model.views;

import java.util.List;

import com.lxiya.xendercart.user.model.view.UserView;

import lombok.Data;

@Data
public class AutherizedUser {

    private UserView user;

    private List<String> roles;
}
