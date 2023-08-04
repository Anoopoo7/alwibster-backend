/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.category.model.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.lxiya.xendercart.category.model.CategoryMedias;
import com.lxiya.xendercart.core.errors.CategoryErrors;
import com.lxiya.xendercart.core.patterns.Patters;

import lombok.Data;

@Data
public class CreateCategoryRequest {

    @NotBlank(message = CategoryErrors.NAME_NULL)
    @Pattern(regexp = Patters.STRING_LIMIT_50, message = CategoryErrors.NAME_LENGTH_LIMIT_EXCEEDS)
    private String name;

    @Pattern(regexp = Patters.STRING_LIMIT_200, message = CategoryErrors.DESCRIPTION_LENGTH_LIMIT_EXCEEDS)
    private String description;

    private List<CategoryMedias> medias;

    private List<String> productIds;

    private List<String> childCategories;
}
