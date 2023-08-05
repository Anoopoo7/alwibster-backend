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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiya.xendercart.product.model.request.CreateSkuRequest;
import com.lxiya.xendercart.product.model.view.CreateSkuView;
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
     * @return CreateSkuView
     */
    @PostMapping
    @PreAuthorize("hasAuthority('XEN_CRT_SKU')")
    public CreateSkuView createSku(@Valid @RequestBody final CreateSkuRequest createSkuRequest) {
        log.info("732D78E3-F5E7-46E7-AD33-C1D2F877F0C9 creating sku with details : {}", createSkuRequest);
        return skuService.createSku(createSkuRequest);
    }
}
