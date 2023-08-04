/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.service;

import com.lxiya.xendercart.category.model.request.CategoryView;
import com.lxiya.xendercart.category.model.request.CreateCategoryRequest;

public interface CategoryService {

    CategoryView createCategory(CreateCategoryRequest createCategoryRequest);

    CategoryView getCategory(String id);

    CategoryView toggleCategory(String id);
}
