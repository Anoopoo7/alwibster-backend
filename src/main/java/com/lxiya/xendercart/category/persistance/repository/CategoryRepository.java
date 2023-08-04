package com.lxiya.xendercart.category.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lxiya.xendercart.category.persistance.entity.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByIdAndActiveAndEnabled(String id, boolean active, boolean enabled);

    Category findByIdAndEnabled(String id, boolean enabled);

}
