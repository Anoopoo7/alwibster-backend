/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.lxiya.xendercart.category.model.CategoryView;
import com.lxiya.xendercart.category.model.request.CreateCategoryRequest;
import com.lxiya.xendercart.category.model.request.UpdateCategoryRequest;
import com.lxiya.xendercart.category.persistance.entity.Category;
import com.lxiya.xendercart.core.UserContext;
import com.lxiya.xendercart.core.utils.StringUtils;

@Component
public class CategoryHelper {

    public static Category constructCategoryFromCreateCategoryRequest(
            CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();
        BeanUtils.copyProperties(createCategoryRequest, category);
        category.setActive(true);
        category.setEnabled(true);
        if (null == category.getCreatedBy()) {
            category.setCreatedBy(UserContext.user().getEmail());
        }
        category.setModifiedBy(UserContext.user().getEmail());
        return category;
    }

    public static CategoryView transformCategoryToView(Category category) {
        CategoryView categoryView = new CategoryView();
        BeanUtils.copyProperties(category, categoryView);
        return categoryView;
    }

    public static List<CategoryView> transformCategoriesToViews(List<Category> data) {
        return !data.isEmpty()
                ? data.stream().map(category -> {
                    CategoryView categoryView = new CategoryView();
                    BeanUtils.copyProperties(category, categoryView);
                    return categoryView;
                }).collect(Collectors.toList())
                : new ArrayList<>();
    }

    public static void updatedCategory(Category category, UpdateCategoryRequest updateCategoryRequest) {
        if (!StringUtils.isBlank(updateCategoryRequest.getName())) {
            category.setName(updateCategoryRequest.getName());
        }
        if (null != updateCategoryRequest.getProductIds()) {
            Set<String> productIdSet = new HashSet<>(updateCategoryRequest.getProductIds());
            category.setProductIds(new ArrayList<>(productIdSet));
        }
        if (null != updateCategoryRequest.getMedias()) {
            category.setMedias(updateCategoryRequest.getMedias());
        }
        if (!StringUtils.isBlank(updateCategoryRequest.getDescription())) {
            category.setDescription(updateCategoryRequest.getDescription());
        }
        if (null != updateCategoryRequest.getChildCategories()) {
            List<String> childCategories = updateCategoryRequest.getChildCategories();
            childCategories.remove(category.getId());
            category.setChildCategories(childCategories);
        }
    }

}
