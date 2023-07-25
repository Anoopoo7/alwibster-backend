/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.persistance.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lxiya.xendercart.product.persistance.entity.Sku;

public interface SkuRepository extends MongoRepository<Sku, String> {

    List<Sku> findByProductIdAndEnabled(String productId, boolean enabled);

}
