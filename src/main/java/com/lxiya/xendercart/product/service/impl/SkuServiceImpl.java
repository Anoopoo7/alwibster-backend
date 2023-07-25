/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiya.xendercart.core.errors.SkuErrors;
import com.lxiya.xendercart.core.utils.StringUtils;
import com.lxiya.xendercart.product.helper.SkuHelper;
import com.lxiya.xendercart.product.model.request.CreateSkuRequest;
import com.lxiya.xendercart.product.model.view.CreateSkuView;
import com.lxiya.xendercart.product.persistance.dao.SkuDao;
import com.lxiya.xendercart.product.persistance.entity.Product;
import com.lxiya.xendercart.product.persistance.entity.Sku;
import com.lxiya.xendercart.product.service.ProductService;
import com.lxiya.xendercart.product.service.SkuService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private ProductService productService;
    @Autowired
    private SkuDao skuDao;

    @Override
    public CreateSkuView createSku(@Valid CreateSkuRequest createSkuRequest) {
        log.info("38BDBCD9-A4A1-4330-A1D3-15399124F741 creating sku with details :{}", createSkuRequest);
        Product product = productService.getProductById(createSkuRequest.getProductId());
        if (null == product) {
            throw new RuntimeException(SkuErrors.PRODUCT_NOT_FOUND);
        }
        Sku sku = SkuHelper.populateSkuFromCreateSkuRequest(createSkuRequest, product.getId());
        sku = skuDao.getSkuRepository().save(sku);
        if (StringUtils.isBlank(product.getDefaultSkuId())) {
            log.info("77990265-EE92-4601-9C6A-004A32203452 setting skuid {} ads default sku id of product {}",
                    sku.getId(), product.getId());
            product.setDefaultSkuId(sku.getId());
            productService.saveProduct(product);
        }
        return SkuHelper.transformSkewToCreateSkuView(sku);
    }

}