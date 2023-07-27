/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.helper;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.lxiya.xendercart.core.UserContext;
import com.lxiya.xendercart.product.model.request.CreateProductRequest;
import com.lxiya.xendercart.product.model.view.CreateProductView;
import com.lxiya.xendercart.product.model.view.ProductView;
import com.lxiya.xendercart.product.model.view.SkuView;
import com.lxiya.xendercart.product.persistance.entity.Product;

public class ProductHelper {

    public static Product constructProductFromCreateProductRequest(CreateProductRequest createProductRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(createProductRequest, product);
        product.setCreatedBy(UserContext.user().getEmail());
        product.setModifiedBy(UserContext.user().getEmail());
        product.setActive(true);
        product.setEnabled(true);
        return product;
    }

    public static CreateProductView transformProductToCreateView(Product product) {
        CreateProductView CreateProductView = new CreateProductView();
        BeanUtils.copyProperties(product, CreateProductView);
        return CreateProductView;
    }

    public static ProductView transformProductToView(Product product, List<SkuView> skus) {
        ProductView productView = new ProductView();
        BeanUtils.copyProperties(product, productView);
        productView.setSkus(skus);
        return productView;
    }

}
