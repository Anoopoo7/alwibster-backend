/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lxiya.xendercart.category.persistance.entity.Category;

public interface CategoryRepository extends MongoRepository<Category, String>, CategoryRepositoryCustom {

    Category findByIdAndActiveAndEnabled(String id, boolean active, boolean enabled);

    Category findByIdAndEnabled(String id, boolean enabled);

}
