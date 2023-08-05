/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.service;

import org.springframework.data.domain.Pageable;

import com.lxiya.xendercart.core.PageView;
import com.lxiya.xendercart.product.model.request.CreateProductRequest;
import com.lxiya.xendercart.product.model.request.EditProductRequest;
import com.lxiya.xendercart.product.model.view.CreateProductView;
import com.lxiya.xendercart.product.model.view.ProductView;
import com.lxiya.xendercart.product.persistance.entity.Product;

public interface ProductService {

    CreateProductView createProduct(final CreateProductRequest createProductRequest);

    Product saveProduct(final Product product);

    ProductView getProduct(final String id);

    PageView<ProductView> getProducts(final String searchTerm, final Pageable pageable);

    ProductView toggleProductStatus(final String id);

    ProductView editProduct(final String id, final EditProductRequest editProductRequest);

}
