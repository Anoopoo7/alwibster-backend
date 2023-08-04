/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiya.xendercart.category.helper.CategoryHelper;
import com.lxiya.xendercart.category.model.request.CategoryView;
import com.lxiya.xendercart.category.model.request.CreateCategoryRequest;
import com.lxiya.xendercart.category.persistance.dao.CategoryDao;
import com.lxiya.xendercart.category.persistance.entity.Category;
import com.lxiya.xendercart.category.service.CategoryService;
import com.lxiya.xendercart.core.UserContext;
import com.lxiya.xendercart.core.errors.CategoryErrors;
import com.lxiya.xendercart.core.utils.StringUtils;
import com.lxiya.xendercart.product.model.view.ProductView;
import com.lxiya.xendercart.product.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductService productService;

    private CategoryView populateCategoryView(Category category, List<String> productIds) {
        List<ProductView> products = null;
        if (!productIds.isEmpty()) {
            products = productIds.stream().map(id -> {
                return productService.getProduct(id);
            }).peek(product -> log.info("9F2A9CA4-9B23-4FAB-82EC-134E4684C5C6 adding products into category view",
                    product)).collect(Collectors.toList());
        }
        return CategoryHelper.transformCategoryToView(category, products);
    }

    @Override
    public CategoryView createCategory(CreateCategoryRequest createCategoryRequest) {
        log.info("7A28495D-2764-47FE-B01D-A91B828D1024 creating category with details {}", createCategoryRequest);
        Category category = CategoryHelper.constructCategoryFromCreateCategoryRequest(createCategoryRequest);
        category = categoryDao.getCategoryRepository().save(category);
        return this.populateCategoryView(category, createCategoryRequest.getProductIds());
    }

    @Override
    public CategoryView getCategory(String id) {
        log.info("AB4C1A19-27EF-425B-A845-1BF6497DCB09 fetching category with id {}", id);
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException(CategoryErrors.CATEGORY_ID_NULL);
        }
        Category category = categoryDao.getCategoryRepository().findByIdAndActiveAndEnabled(id, true, true);
        if (null == category) {
            throw new RuntimeException(CategoryErrors.NO_CATEGORIES_FOUNDS);
        }
        return this.populateCategoryView(category, category.getProductIds());
    }

    @Override
    public CategoryView toggleCategory(String id) {
        log.info("C220212A-8A1E-4FEA-B77D-483B5A5BCE7C editing category status with category id : {}", id);
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException(CategoryErrors.CATEGORY_ID_NULL);
        }
        Category category = categoryDao.getCategoryRepository().findByIdAndEnabled(id, true);
        if (null == category) {
            throw new RuntimeException(CategoryErrors.NO_CATEGORIES_FOUNDS);
        }
        category.setActive(!category.isActive());
        category.setUpdatedDate(new Date());
        category.setModifiedBy(UserContext.user().getEmail());
        return this.populateCategoryView(categoryDao.getCategoryRepository().save(category), category.getProductIds());
    }

}
