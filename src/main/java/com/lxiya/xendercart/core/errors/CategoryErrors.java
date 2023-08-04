/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.core.errors;

import lombok.Data;

@Data
public class CategoryErrors {

    public static final String NAME_NULL = "Name should not be empty.";

    public static final String NAME_LENGTH_LIMIT_EXCEEDS = "Name must be between 1 and 50 characters.";

    public static final String DESCRIPTION_LENGTH_LIMIT_EXCEEDS = "Name must be between 1 and 200 characters";

    public static final String CATEGORY_ID_NULL = "Category id is mandatory";

    public static final String NO_CATEGORIES_FOUNDS = "No categories found";

}
