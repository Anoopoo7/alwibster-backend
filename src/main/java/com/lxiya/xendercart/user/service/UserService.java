/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.user.service;

import javax.servlet.http.HttpServletRequest;

import com.lxiya.xendercart.user.model.request.UserRequest;
import com.lxiya.xendercart.user.model.view.UserView;

public interface UserService {

    UserView createUser(UserRequest user, HttpServletRequest request);

    UserView getUserByEmailAndPassword(String email, String password);

    UserView getUser(String id);

}
