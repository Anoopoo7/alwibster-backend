/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.user.service.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiya.xendercart.core.errors.UserErrors;
import com.lxiya.xendercart.core.utils.StringUtils;
import com.lxiya.xendercart.user.helper.UserHelper;
import com.lxiya.xendercart.user.model.request.UserRequest;
import com.lxiya.xendercart.user.model.view.UserView;
import com.lxiya.xendercart.user.persistance.dao.UserDao;
import com.lxiya.xendercart.user.persistance.entity.User;
import com.lxiya.xendercart.user.service.UserService;
import com.lxiya.xendercart.user.utils.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserView createUser(final UserRequest userRequest, HttpServletRequest request) {
        log.info("091C5459-BA72-44F7-ABAE-6A9BB72B20B7 creating user with details : {}", userRequest);
        String email = userRequest.getEmail();
        String mobile = userRequest.getMobile();
        User existingUser = userDao.getUserRepository().findUserWithEmailOrMobile(email, mobile);
        if (null != existingUser) {
            throw new RuntimeException(UserErrors.DUPLICATE_EMAIL_OR_MOBILE);
        }
        User user = UserHelper.transformUserRequestToUser(userRequest);
        return UserHelper.transformToView(userDao.getUserRepository().save(user));
    }

    @Override
    public UserView getUserByEmailAndPassword(final String email, final String password) {
        log.info("EB82B5BE-8AA9-4760-B13F-A9465299658F finding user with email : " + email + " and password : "
                + password);
        if (StringUtils.isBlank(email)) {
            throw new RuntimeException(UserErrors.EMAIL_INVALID);
        }
        User user = userDao.getUserRepository().findUserByEmailAndEnabledAndActive(email, true, true);
        if (null != user && PasswordEncoder.matches(password, user.getPassword())) {
            return UserHelper.transformToView(user);
        }
        throw new RuntimeException(UserErrors.USER_NOT_FOUND);
    }

    @Override
    public UserView getUser(final String id) {
        log.info("839B7E40-543D-422F-BEB8-A27025738DCD fetching user with id : {}", id);
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException(UserErrors.USER_ID_INVALID);
        }
        Optional<User> OptionalUser = userDao.getUserRepository().findByIdAndActive(id, true);
        if (OptionalUser.isPresent()) {
            return UserHelper.transformToView(OptionalUser.get());
        }
        throw new RuntimeException(UserErrors.USER_NOT_FOUND);
    }

}
