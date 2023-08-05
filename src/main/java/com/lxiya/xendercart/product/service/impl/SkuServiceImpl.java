/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiya.xendercart.core.errors.SkuErrors;
import com.lxiya.xendercart.core.utils.StringUtils;
import com.lxiya.xendercart.product.helper.SkuHelper;
import com.lxiya.xendercart.product.model.request.CreateSkuRequest;
import com.lxiya.xendercart.product.model.view.CreateSkuView;
import com.lxiya.xendercart.product.model.view.SkuView;
import com.lxiya.xendercart.product.persistance.dao.SkuDao;
import com.lxiya.xendercart.product.persistance.entity.Sku;
import com.lxiya.xendercart.product.service.SkuService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuDao skuDao;

    @Override
    public CreateSkuView createSku(final CreateSkuRequest createSkuRequest) {
        log.info("38BDBCD9-A4A1-4330-A1D3-15399124F741 creating sku with details :{}", createSkuRequest);
        Sku sku = SkuHelper.populateSkuFromCreateSkuRequest(createSkuRequest, createSkuRequest.getProductId());
        sku = skuDao.getSkuRepository().save(sku);
        return SkuHelper.transformSkewToCreateSkuView(sku);
    }

    @Override
    public List<SkuView> getSkusByProductId(final String id) {
        log.info("A8515460-E97B-42B5-B60E-E28ED9EBB2D7 fetching product by id {}", id);
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException(SkuErrors.PRODUCT_ID_NULL);
        }
        List<Sku> skus = skuDao.getSkuRepository().findAllSkuByProductIdAndActiveAndEnabled(id, true, true);
        if (skus.isEmpty()) {
            log.warn("7E2EFDCE-1E7B-41D4-92F3-3B9355334EED no skus found for the product id {}", id);
            return null;
        }
        return SkuHelper.transformSkusToView(skus);
    }

}
