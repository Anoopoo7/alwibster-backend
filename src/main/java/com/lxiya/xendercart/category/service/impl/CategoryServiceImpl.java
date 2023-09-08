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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lxiya.xendercart.category.helper.CategoryHelper;
import com.lxiya.xendercart.category.model.CategoryView;
import com.lxiya.xendercart.category.model.request.CreateCategoryRequest;
import com.lxiya.xendercart.category.model.request.UpdateCategoryRequest;
import com.lxiya.xendercart.category.persistance.dao.CategoryDao;
import com.lxiya.xendercart.category.persistance.entity.Category;
import com.lxiya.xendercart.category.service.CategoryService;
import com.lxiya.xendercart.core.PageView;
import com.lxiya.xendercart.core.UserContext;
import com.lxiya.xendercart.core.errors.CategoryErrors;
import com.lxiya.xendercart.core.utils.StringUtils;
import com.lxiya.xendercart.product.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductService productService;

    @Override
    public CategoryView createCategory(final CreateCategoryRequest createCategoryRequest) {
        log.info("7A28495D-2764-47FE-B01D-A91B828D1024 creating category with details {}", createCategoryRequest);
        Category category = CategoryHelper.constructCategoryFromCreateCategoryRequest(createCategoryRequest);
        category = categoryDao.getCategoryRepository().save(category);
        return CategoryHelper.transformCategoryToView(category);
    }

    @Override
    public CategoryView getCategory(final String id) {
        log.info("AB4C1A19-27EF-425B-A845-1BF6497DCB09 fetching category with id {}", id);
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException(CategoryErrors.CATEGORY_ID_NULL);
        }
        Category category = categoryDao.getCategoryRepository().findByIdAndEnabled(id, true);
        if (null == category) {
            throw new RuntimeException(CategoryErrors.NO_CATEGORIES_FOUNDS);
        }
        category = categoryDao.getCategoryRepository().save(category);
        return CategoryHelper.transformCategoryToView(category);
    }

    @Override
    public CategoryView toggleCategoryStatus(final String id) {
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
        category = categoryDao.getCategoryRepository().save(category);
        return CategoryHelper.transformCategoryToView(category);
    }

    @Override
    public PageView<CategoryView> getCategories(final String searchTerm, Pageable pageable) {
        log.info("7B867260-521B-4CBE-B340-3323FE09EE25 fetching chategories with searchTerm : {}", searchTerm);
        PageView<Category> categoryPage = categoryDao.getCategoryRepository().searchCategories(searchTerm, pageable);
        List<CategoryView> CategoryViews = CategoryHelper.transformCategoriesToViews(categoryPage.getData());
        return new PageView<>(CategoryViews, categoryPage);
    }

    @Override
    public CategoryView updateCategory(final String id, final UpdateCategoryRequest updateCategoryRequest) {
        log.info("E3D1F557-F98E-4196-A5E6-2ED347A0D166 updating category {} with data {}", id, updateCategoryRequest);
        Category category = categoryDao.getCategoryRepository().findByIdAndEnabled(id, true);
        if (null == category) {
            throw new RuntimeException(CategoryErrors.NO_CATEGORIES_FOUNDS);
        }
        CategoryHelper.updatedCategory(category, updateCategoryRequest);
        category = categoryDao.getCategoryRepository().save(category);
        return CategoryHelper.transformCategoryToView(category);
    }

}
