/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.persistance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lxiya.xendercart.product.persistance.repository.ProductRepository;

@Component
public class ProductDao {

    @Autowired
    private ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return this.productRepository;
    }

}
