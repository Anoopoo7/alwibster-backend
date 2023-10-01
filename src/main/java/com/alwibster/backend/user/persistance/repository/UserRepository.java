/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.user.persistance.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alwibster.backend.user.persistance.entity.User;

public interface UserRepository extends MongoRepository<User, String>, UserCustomRepository {

    User findUserByEmailAndEnabledAndActive(String email, boolean enabled, boolean active);

    Optional<User> findByIdAndActive(String id, boolean b);

}
