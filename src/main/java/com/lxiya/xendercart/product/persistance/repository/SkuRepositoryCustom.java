/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.persistance.repository;

import org.springframework.data.domain.Pageable;

import com.lxiya.xendercart.core.PageView;
import com.lxiya.xendercart.product.persistance.entity.Sku;

public interface SkuRepositoryCustom {

    PageView<Sku> findSkues(String productId, Pageable pageRequest);
}
