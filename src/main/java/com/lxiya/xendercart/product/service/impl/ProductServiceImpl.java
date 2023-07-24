/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiya.xendercart.product.helper.ProductHelper;
import com.lxiya.xendercart.product.model.request.CreateProductRequest;
import com.lxiya.xendercart.product.model.view.CreateProductView;
import com.lxiya.xendercart.product.persistance.dao.ProductDao;
import com.lxiya.xendercart.product.persistance.entity.Product;
import com.lxiya.xendercart.product.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public CreateProductView createProduct(final CreateProductRequest createProductRequest) {
        log.info("E94805C3-D0F9-4BE3-8D24-FE6667BC7FB6 creating product with details {}", createProductRequest);
        Product product = ProductHelper.constructProductFromCreateProductRequest(createProductRequest);
        log.info("0FB73972-02F9-4494-B3C3-005F445EFBE9 saving product: {}", product);
        return ProductHelper.transformProductToView(productDao.getProductRepository().save(product));
    }

}
