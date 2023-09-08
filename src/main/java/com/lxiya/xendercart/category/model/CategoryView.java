/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.model;

import java.util.List;

import lombok.Data;

@Data
public class CategoryView {

    private String id;

    private String name;

    private String description;

    private boolean active;

    private List<String> productIds;

    private List<CategoryMedias> medias;

    private List<String> childCategories;
}
