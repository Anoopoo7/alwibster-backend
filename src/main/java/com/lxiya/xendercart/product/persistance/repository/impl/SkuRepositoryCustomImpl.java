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
import com.lxiya.xendercart.product.persistance.entity.Sku;
import com.lxiya.xendercart.product.persistance.repository.SkuRepositoryCustom;

@Repository
public class SkuRepositoryCustomImpl implements SkuRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public PageView<Sku> findSkues(String productId, Pageable pageRequest) {
        Query query = new Query();
        Criteria searchriteria = new Criteria();
        searchriteria.andOperator(Criteria.where("enabled").is(true), Criteria.where("productId").is(productId));
        query.addCriteria(searchriteria);
        long matches = mongoTemplate.count(query, Sku.class);
        query.with(pageRequest);
        List<Sku> skus = mongoTemplate.find(query, Sku.class);
        return new PageView<Sku>(matches, skus, pageRequest);
    }

}
