/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.helper;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.lxiya.xendercart.category.model.request.CategoryView;
import com.lxiya.xendercart.category.model.request.CreateCategoryRequest;
import com.lxiya.xendercart.category.persistance.entity.Category;
import com.lxiya.xendercart.core.UserContext;
import com.lxiya.xendercart.product.model.view.ProductView;

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

    public static CategoryView transformCategoryToView(Category save, List<ProductView> products) {
        CategoryView categoryView = new CategoryView();
        BeanUtils.copyProperties(save, categoryView);
        categoryView.setProducts(products);
        return categoryView;
    }

}
