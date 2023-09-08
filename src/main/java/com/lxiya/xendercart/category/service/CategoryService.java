/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.service;

import org.springframework.data.domain.Pageable;

import com.lxiya.xendercart.category.model.CategoryView;
import com.lxiya.xendercart.category.model.request.CreateCategoryRequest;
import com.lxiya.xendercart.category.model.request.UpdateCategoryRequest;
import com.lxiya.xendercart.core.PageView;

public interface CategoryService {

    CategoryView createCategory(final CreateCategoryRequest createCategoryRequest);

    CategoryView getCategory(final String id);

    CategoryView toggleCategoryStatus(final String id);

    PageView<CategoryView> getCategories(final String searchTerm, Pageable pageable);

    CategoryView updateCategory(final String id, final UpdateCategoryRequest updateCategoryRequest);
}
