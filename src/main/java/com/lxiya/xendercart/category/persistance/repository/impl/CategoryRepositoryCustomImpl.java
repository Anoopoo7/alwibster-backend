/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.persistance.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lxiya.xendercart.category.persistance.entity.Category;
import com.lxiya.xendercart.category.persistance.repository.CategoryRepositoryCustom;
import com.lxiya.xendercart.core.PageView;
import com.lxiya.xendercart.core.utils.StringUtils;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public PageView<Category> searchCategories(String searchTerm, Pageable pageable) {
        Query query = new Query();
        Criteria searchriteria = new Criteria();
        if (!StringUtils.isBlank(searchTerm)) {
            searchriteria.orOperator(
                    Criteria.where("name").regex(searchTerm, "i"),
                    Criteria.where("id").is(searchTerm));
        }
        searchriteria.andOperator(Criteria.where("enabled").is(true));
        query.addCriteria(searchriteria);
        long matches = mongoTemplate.count(query, Category.class);
        query.with(pageable);
        List<Category> categories = mongoTemplate.find(query, Category.class);
        return new PageView<Category>(matches, categories, pageable);
    }

}
