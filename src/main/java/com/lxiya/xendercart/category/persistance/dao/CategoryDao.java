/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.persistance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lxiya.xendercart.category.persistance.repository.CategoryRepository;

@Component
public class CategoryDao {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryRepository getCategoryRepository() {
        return this.categoryRepository;
    }

}
