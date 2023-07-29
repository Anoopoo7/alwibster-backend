/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.helper;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.lxiya.xendercart.core.UserContext;
import com.lxiya.xendercart.product.model.request.CreateSkuRequest;
import com.lxiya.xendercart.product.model.view.CreateSkuView;
import com.lxiya.xendercart.product.model.view.SkuView;
import com.lxiya.xendercart.product.persistance.entity.Sku;

@Component
public class SkuHelper {

    public static Sku populateSkuFromCreateSkuRequest(@Valid CreateSkuRequest createSkuRequest, String productId) {
        Sku sku = new Sku();
        BeanUtils.copyProperties(createSkuRequest, sku);
        sku.setProductId(productId);
        sku.setModifiedBy(UserContext.user().getEmail());
        sku.setCreatedBy(UserContext.user().getEmail());
        sku.setActive(true);
        sku.setEnabled(true);
        return sku;
    }

    public static CreateSkuView transformSkewToCreateSkuView(Sku sku) {
        CreateSkuView createSkuView = new CreateSkuView();
        BeanUtils.copyProperties(sku, createSkuView);
        return createSkuView;
    }

    public static List<SkuView> transformSkusToView(List<Sku> skus) {
        return skus.stream().map(sku -> {
            SkuView skuView = new SkuView();
            BeanUtils.copyProperties(sku, skuView);
            return skuView;
        }).collect(Collectors.toList());
    }

}
