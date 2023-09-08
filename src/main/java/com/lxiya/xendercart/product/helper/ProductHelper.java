/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.lxiya.xendercart.core.UserContext;
import com.lxiya.xendercart.core.utils.StringUtils;
import com.lxiya.xendercart.product.model.request.CreateProductRequest;
import com.lxiya.xendercart.product.model.request.EditProductRequest;
import com.lxiya.xendercart.product.model.view.ProductView;
import com.lxiya.xendercart.product.persistance.entity.Product;

public class ProductHelper {

    public static Product constructProductFromCreateProductRequest(CreateProductRequest createProductRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(createProductRequest, product);
        product.setCreatedBy(UserContext.user().getEmail());
        product.setSkus(new ArrayList<String>());
        product.setActive(true);
        product.setEnabled(true);
        return product;
    }

    public static ProductView transformProductToView(Product product) {
        ProductView productView = new ProductView();
        BeanUtils.copyProperties(product, productView);
        return productView;
    }

    public static List<ProductView> transformProductsToViews(List<Product> products) {
        return !products.isEmpty() ? products.stream().map(product -> {
            ProductView productView = new ProductView();
            BeanUtils.copyProperties(product, productView);
            return productView;
        }).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static void populateProductFromEditRequest(Product product, EditProductRequest editProductRequest) {
        if (!StringUtils.isBlank(editProductRequest.getName())) {
            product.setName(editProductRequest.getName());
        }
        if (!StringUtils.isBlank(editProductRequest.getBrandId())) {
            product.setBrandId(editProductRequest.getBrandId());
        }
        if (!StringUtils.isBlank(editProductRequest.getCategoryId())) {
            product.setCategoryId(editProductRequest.getCategoryId());
        }
        if (!StringUtils.isBlank(editProductRequest.getSaleStartDate())) {
            product.setSaleStartDate(editProductRequest.getSaleStartDate());
        }
        if (!StringUtils.isBlank(editProductRequest.getSaleStartDate())) {
            product.setSaleStartDate(editProductRequest.getSaleStartDate());
        }
        if (null != editProductRequest.getRating()) {
            product.setRating(editProductRequest.getRating());
        }
        if (null != editProductRequest.getAddOns()) {
            product.setAddOns(editProductRequest.getAddOns());
        }
        if (null != editProductRequest.getChildProducts()) {
            product.setChildProducts(editProductRequest.getChildProducts());
        }
        if (null != editProductRequest.getRelatedProducts()) {
            product.setRelatedProducts(editProductRequest.getRelatedProducts());
        }
        product.setUpdatedDate(new Date());
        product.setModifiedBy(UserContext.user().getEmail());
    }

}
