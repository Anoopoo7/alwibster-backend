/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lxiya.xendercart.product.persistance.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
