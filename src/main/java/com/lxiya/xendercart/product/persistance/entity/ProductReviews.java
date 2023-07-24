/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.persistance.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.lxiya.xendercart.core.BaseEntity;
import com.lxiya.xendercart.product.model.ProductMedias;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "xen_product_reviews")
public class ProductReviews extends BaseEntity {

    private String customerId;

    private String comment;

    private List<ProductMedias> images;

    private String productId;

    private Integer rating;

}
