/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.model.request;

import java.util.List;

import com.lxiya.xendercart.category.model.CategoryMedias;
import com.lxiya.xendercart.product.model.view.ProductView;

import lombok.Data;

@Data
public class CategoryView {

    private String id;

    private String name;

    private String description;

    private List<ProductView> products;

    private List<CategoryMedias> medias;

    private List<String> childCategories;
}
