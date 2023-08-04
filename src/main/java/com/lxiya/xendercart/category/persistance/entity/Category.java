/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.persistance.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.lxiya.xendercart.category.model.CategoryMedias;
import com.lxiya.xendercart.core.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "xen_categories")
public class Category extends BaseEntity {

    private String name;

    private List<String> productIds;

    private List<CategoryMedias> medias;

    private String description;

    private List<String> childCategories;

}
