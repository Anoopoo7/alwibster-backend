/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.persistance.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lxiya.xendercart.core.PageView;
import com.lxiya.xendercart.core.utils.StringUtils;
import com.lxiya.xendercart.product.persistance.entity.Product;
import com.lxiya.xendercart.product.persistance.repository.ProductRepositoryCustom;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public PageView<Product> searchProducts(String searchTerm, Pageable pageable) {
        Query query = new Query();
        Criteria searchriteria = new Criteria();
        if (!StringUtils.isBlank(searchTerm)) {
            searchriteria.orOperator(
                    Criteria.where("name").regex(searchTerm, "i"),
                    Criteria.where("id").is(searchTerm));
        }
        searchriteria.andOperator(Criteria.where("enabled").is(true));
        query.addCriteria(searchriteria);
        long matches = mongoTemplate.count(query, Product.class);
        query.with(pageable);
        List<Product> products = mongoTemplate.find(query, Product.class);
        return new PageView<Product>(matches, products, pageable);
    }

}
// Criteria.where("enabled").is(true)