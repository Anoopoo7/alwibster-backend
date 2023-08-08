/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.service;

import java.util.List;

import com.lxiya.xendercart.product.model.request.CreateSkuRequest;
import com.lxiya.xendercart.product.model.view.CreateSkuView;
import com.lxiya.xendercart.product.model.view.SkuView;

public interface SkuService {

    CreateSkuView createSku(final CreateSkuRequest createSkuRequest);

    List<SkuView> getSkusByProductId(final String id);

    SkuView toggleSkuStatus(String id);

    SkuView getSku(String id);

}
