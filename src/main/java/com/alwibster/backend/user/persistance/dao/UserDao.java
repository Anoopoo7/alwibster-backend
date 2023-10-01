/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.user.persistance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alwibster.backend.user.persistance.repository.UserRepository;

@Component
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return this.userRepository;
    }

}
