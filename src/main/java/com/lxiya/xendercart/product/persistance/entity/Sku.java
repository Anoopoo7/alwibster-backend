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
@Document(collection = "xen_skus")
public class Sku extends BaseEntity {

    private String location;

    private int stock;

    private int listPrice;

    private int salePrice;

    private String varient;

    private String shortDescription;

    private String keyWords;

    private String longDescription;

    private List<ProductMedias> medias;

    private boolean hotStock;
}
