/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.user.persistance.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lxiya.xendercart.user.persistance.entity.User;

public interface UserRepository extends MongoRepository<User, String>, UserCustomRepository {

    User findUserByEmailAndEnabledAndActive(String email, boolean enabled, boolean active);

    Optional<User> findByIdAndActive(String id, boolean b);

}
