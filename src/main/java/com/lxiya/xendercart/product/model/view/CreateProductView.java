/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.model.view;

import java.util.List;

import com.lxiya.xendercart.product.model.ProductMedias;

import lombok.Data;

@Data
public class CreateProductView {

    private String id;

    private String name;

    private String brandId;

    private String categoryId;

    private List<ProductMedias> defaultMedias;

    private List<String> addOns;

    private List<String> childProducts;

    private List<String> relatedProducts;

    private String saleStartDate;

    private String saleEndDate;
}
