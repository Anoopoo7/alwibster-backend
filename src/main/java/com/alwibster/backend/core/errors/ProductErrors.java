/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.core.errors;

import org.springframework.stereotype.Component;

@Component
public class ProductErrors {

    public static final String NAME_NULL = "Name should not be empty.";

    public static final String DATE_INVALID = "Invalid date, Date Should be in 'DD-MM-YYYY' format.";

    public static final String NAME_LENGTH_LIMIT_EXCEEDS = "Name must be between 1 and 100 characters.";

    public static final String PRODUCT_ID_NULL = "ProductId is mandatory.";

    public static final String PRODUCT_NOT_FOUND = "Product not found";

}
