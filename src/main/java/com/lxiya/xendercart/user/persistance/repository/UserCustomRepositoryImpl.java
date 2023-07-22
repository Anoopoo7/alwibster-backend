/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.user.persistance.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lxiya.xendercart.user.persistance.entity.User;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User findUserWithEmailOrMobile(String email, String mobile) {
        Query query = new Query();
        Criteria nameCriteria = new Criteria().orOperator(
                Criteria.where("email").is(email),
                Criteria.where("mobile").is(mobile),
                Criteria.where("enabled").is(mobile));
        query.addCriteria(nameCriteria);
        return mongoTemplate.findOne(query, User.class);
    }

}
