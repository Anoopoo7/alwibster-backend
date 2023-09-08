/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.model.view;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ProductView {

    private String id;

    private String name;

    private boolean active;

    private List<String> skus;

    private String brandId;

    private String categoryId;

    private List<String> addOns;

    private List<String> childProducts;

    private List<String> relatedProducts;

    private Map<String, String> badge;

    private Integer rating;

    private String saleStartDate;

    private String saleEndDate;
}
