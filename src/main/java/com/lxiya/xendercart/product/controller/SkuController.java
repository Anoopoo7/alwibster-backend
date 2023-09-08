/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiya.xendercart.core.PageView;
import com.lxiya.xendercart.product.model.request.CreateSkuRequest;
import com.lxiya.xendercart.product.model.view.SkuView;
import com.lxiya.xendercart.product.service.SkuService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    /**
     * Create sku
     * 
     * @param createSkuRequest
     * @return SkuView
     */
    @PostMapping
    @PreAuthorize("hasAuthority('XEN_CRT_SKU')")
    public SkuView createSku(@Valid @RequestBody final CreateSkuRequest createSkuRequest) {
        log.info("732D78E3-F5E7-46E7-AD33-C1D2F877F0C9 creating sku with details : {}", createSkuRequest);
        return skuService.createSku(createSkuRequest);
    }

    /**
     * * Toggle sku status
     * 
     * @param id
     * @return SkuView
     */
    @PatchMapping("/edit/id/{id}")
    @PreAuthorize("hasAuthority('XEN_EDT_SKU')")
    public SkuView toggleSkuStatus(@PathVariable final String id) {
        log.info("DEB46A7B-F08E-4DF2-A1FE-E7B92CB3C0DD editing sku status with id : {}", id);
        return skuService.toggleSkuStatus(id);
    }

    /**
     * Fetch sku details
     * 
     * @param id
     * @return SkuView
     */
    @GetMapping("/id/{id}")
    @PreAuthorize("hasAuthority('XEN_VWE_SKU')")
    public SkuView getSku(@PathVariable final String id) {
        log.info("DD7D5B36E-A80D-4D77-8B4D-CDFC13DDAE02 get sku by id : {}", id);
        return skuService.getSku(id);
    }

    /**
     * Fetch all Skus of products
     * 
     * @param productId
     * @param pageRequest
     * @return PageView<SkuView>
     */
    @GetMapping("/productId/{productId}")
    @PreAuthorize("hasAuthority('XEN_VWE_SKU')")
    public PageView<SkuView> getSkus(@PathVariable final String productId, final Pageable pageRequest) {
        log.info("A2417C76-E815-49BC-A974-775D069824E2 fetching skus for the product : {}", productId);
        return skuService.getSkus(productId, pageRequest);
    }

}
