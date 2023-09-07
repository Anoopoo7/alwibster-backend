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
public class SkuView {

    private String id;

    private String productId;

    private String location;

    private int stock;

    private int listPrice;

    private int salePrice;

    private String varient;

    private String shortDescription;

    private String keyWords;

    private String longDescription;

    private boolean isDefault;

    private boolean active;

    private List<ProductMedias> medias;

    private boolean customImages;

    private boolean hotStock;
}
