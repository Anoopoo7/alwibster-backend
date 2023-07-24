/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.persistance.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.lxiya.xendercart.core.BaseEntity;
import com.lxiya.xendercart.product.model.ProductMedias;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "xen_products")
public class Product extends BaseEntity {

    private String name;

    private String defaultSkuId;

    private String seller;

    private String brandId;

    private String categoryId;

    private List<ProductMedias> DefaultMedias;

    private List<String> addOns;

    private List<String> childProducts;

    private List<String> relatedProducts;

    private Map<String, String> badge;

    private Integer rating;

    private Date saleStartDate;

    private Date saleEndDate;

}
