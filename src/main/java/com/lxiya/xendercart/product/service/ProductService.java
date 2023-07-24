/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.service;

import com.lxiya.xendercart.product.model.request.CreateProductRequest;
import com.lxiya.xendercart.product.model.view.CreateProductView;

public interface ProductService {

    CreateProductView createProduct(final CreateProductRequest createProductRequest);

}
