/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.user.service;

import javax.servlet.http.HttpServletRequest;

import com.alwibster.backend.user.model.request.UserRequest;
import com.alwibster.backend.user.model.view.UserView;

public interface UserService {

    UserView createUser(final UserRequest user, HttpServletRequest request);

    UserView getUserByEmailAndPassword(final String email, String password);

    UserView getUser(final String id);

}
