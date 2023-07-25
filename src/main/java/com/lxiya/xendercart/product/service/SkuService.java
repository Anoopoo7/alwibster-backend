/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.service;

import javax.validation.Valid;

import com.lxiya.xendercart.product.model.request.CreateSkuRequest;
import com.lxiya.xendercart.product.model.view.CreateSkuView;

public interface SkuService {

    CreateSkuView createSku(@Valid CreateSkuRequest createSkuRequest);

}
