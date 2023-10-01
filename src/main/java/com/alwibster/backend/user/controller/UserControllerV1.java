/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alwibster.backend.user.model.request.UserRequest;
import com.alwibster.backend.user.model.view.UserView;
import com.alwibster.backend.user.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/user")
public class UserControllerV1 {

    @Autowired
    private UserService userService;

    /**
     * Create user
     * 
     * @param user
     * @param request
     * @return UserView
     */
    @PostMapping
    @PreAuthorize("hasAuthority('XEN_CRT_USR')")
    public UserView createUser(@Valid @RequestBody final UserRequest user, final HttpServletRequest request) {
        log.info("023516AD-9ED3-43D5-85E0-8B1A8BBA4F8A creating user with details : ", user);
        return userService.createUser(user, request);
    }

    /**
     * Find user
     * 
     * @param id
     * @return UserView
     */
    @GetMapping("/id/{id}")
    @PreAuthorize("hasAuthority('XEN_VWE_USR')")
    public UserView getUser(@PathVariable final String id) {
        log.info("B43A5459-A1A6-42B6-9799-53446E3AC8C5 fetching user with id : {}", id);
        return userService.getUser(id);
    }
}
