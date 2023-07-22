/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.user.helper;

import org.springframework.beans.BeanUtils;

import com.lxiya.xendercart.organization.model.constants.RoleConstances;
import com.lxiya.xendercart.user.model.request.UserRequest;
import com.lxiya.xendercart.user.model.view.UserView;
import com.lxiya.xendercart.user.persistance.entity.User;
import com.lxiya.xendercart.user.utils.PasswordEncoder;

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
