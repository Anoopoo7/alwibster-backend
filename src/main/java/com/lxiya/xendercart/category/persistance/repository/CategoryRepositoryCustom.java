/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.persistance.repository;

import org.springframework.data.domain.Pageable;

import com.lxiya.xendercart.category.persistance.entity.Category;
import com.lxiya.xendercart.core.PageView;

public interface CategoryRepositoryCustom {

    PageView<Category> searchCategories(String searchTerm, Pageable pageable);

}
