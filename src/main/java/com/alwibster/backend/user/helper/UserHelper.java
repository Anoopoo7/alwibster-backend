/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.user.helper;

import org.springframework.beans.BeanUtils;

import com.alwibster.backend.organization.model.constants.RoleConstances;
import com.alwibster.backend.user.model.request.UserRequest;
import com.alwibster.backend.user.model.view.UserView;
import com.alwibster.backend.user.persistance.entity.User;
import com.alwibster.backend.user.utils.PasswordEncoder;

public class UserHelper {

    public static User transformUserRequestToUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        user.setActive(true);
        user.setEnabled(true);
        user.setFirstOrder(true);
        user.setRole(RoleConstances.customer);
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        return user;
    }

    public static UserView transformToView(User user) {
        UserView userView = new UserView();
        BeanUtils.copyProperties(user, userView);
        return userView;
    }

}
