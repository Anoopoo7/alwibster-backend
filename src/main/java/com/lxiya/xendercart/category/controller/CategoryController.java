/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lxiya.xendercart.category.model.CategoryView;
import com.lxiya.xendercart.category.model.request.CreateCategoryRequest;
import com.lxiya.xendercart.category.model.request.UpdateCategoryRequest;
import com.lxiya.xendercart.category.service.CategoryService;
import com.lxiya.xendercart.core.PageView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Create category
     * 
     * @param createCategoryRequest
     * @return CategoryView
     */
    @PostMapping
    @PreAuthorize("hasAuthority('XEN_CRT_CAT')")
    public CategoryView createCategory(@Valid @RequestBody final CreateCategoryRequest createCategoryRequest) {
        log.info("953EC037-62D1-4A9B-957A-8BA619C08E31 creating category with details : {}", createCategoryRequest);
        return categoryService.createCategory(createCategoryRequest);
    }

    /**
     * Find category
     * 
     * @param id
     * @return CategoryView
     */
    @GetMapping("/id/{id}")
    @PreAuthorize("hasAuthority('XEN_VWE_CAT')")
    public CategoryView getCategory(@PathVariable final String id) {
        log.info("2A1E6FCC-46FD-4222-86B6-93CD1FDBBD60 fetching category with id : {}", id);
        return categoryService.getCategory(id);
    }

    /**
     * Toggle category status
     * 
     * @param id
     * @return CategoryView
     */
    @PatchMapping("/edit/id/{id}")
    @PreAuthorize("hasAuthority('XEN_EDT_CAT')")
    public CategoryView toggleCategoryStatus(@PathVariable final String id) {
        log.info("DE59FDEA-02F5-4084-9D71-3BA022EE6035 editing category status with category id : {}", id);
        return categoryService.toggleCategoryStatus(id);
    }

    /**
     * List/search categories
     * 
     * @param searchTerm
     * @param pageable
     * @return PageView<CategoryView>
     */
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('XEN_VWE_CAT')")
    public PageView<CategoryView> getCategories(@RequestParam(required = false) final String searchTerm,
            final Pageable pageable) {
        log.info("ADB342A2-47A2-4918-BB19-1367C199539F fetching chategories with searchTerm : {}", searchTerm);
        return categoryService.getCategories(searchTerm, pageable);
    }

    @PutMapping("/edit/id/{id}")
    @PreAuthorize("hasAuthority('XEN_EDT_CAT')")
    public CategoryView updateCategory(@PathVariable final String id,
            @RequestBody final UpdateCategoryRequest updateCategoryRequest) {
        log.info("2D8FE371-B61E-4E1F-8A0A-B80B453F59B6 updating chategory : {}", id);
        return categoryService.updateCategory(id, updateCategoryRequest);
    }

}
