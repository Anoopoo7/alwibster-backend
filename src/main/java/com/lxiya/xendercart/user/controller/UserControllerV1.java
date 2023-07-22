/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiya.xendercart.user.model.request.UserRequest;
import com.lxiya.xendercart.user.model.view.UserView;
import com.lxiya.xendercart.user.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/user")
public class UserControllerV1 {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserView createUser(@Valid @RequestBody final UserRequest user, HttpServletRequest request) {
        log.info("023516AD-9ED3-43D5-85E0-8B1A8BBA4F8A creating user with details : ", user);
        return userService.createUser(user, request);
    }

    @GetMapping("/id/{id}")
    public UserView getUser(@PathVariable final String id) {
        log.info("B43A5459-A1A6-42B6-9799-53446E3AC8C5 fetching user with id : {}", id);
        return userService.getUser(id);
    }
}