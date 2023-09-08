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

import lombok.Data;

@Data
public class UpdateCategoryRequest {

    private String name;

    private List<String> productIds;

    private List<CategoryMedias> medias;

    private String description;

    private List<String> childCategories;
}
