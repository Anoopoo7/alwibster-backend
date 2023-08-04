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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiya.xendercart.category.model.request.CategoryView;
import com.lxiya.xendercart.category.model.request.CreateCategoryRequest;
import com.lxiya.xendercart.category.service.CategoryService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasAuthority('XEN_CRT_CAT')")
    public CategoryView createCategory(@Valid @RequestBody final CreateCategoryRequest createCategoryRequest) {
        log.info("953EC037-62D1-4A9B-957A-8BA619C08E31 creating category with details : {}", createCategoryRequest);
        return categoryService.createCategory(createCategoryRequest);
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("hasAuthority('XEN_VWE_CAT')")
    public CategoryView getCategory(@PathVariable String id) {
        log.info("2A1E6FCC-46FD-4222-86B6-93CD1FDBBD60 fetching category with id : {}", id);
        return categoryService.getCategory(id);
    }
}
