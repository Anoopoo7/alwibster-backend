/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.core.errors;

import org.springframework.stereotype.Controller;

@Controller
public class SkuErrors {

    public static final String PRODUCT_ID_NULL = "ProductId is mandatory";

    public static final String LOCATION_NULL = "Lcation is mandatory";

    public static final String STOCK_NULL = "Stock is mandatory";

    public static final String LIST_PRICE_NULL = "List is mandatory";

    public static final String SALE_PRICE_NULL = "Sale price is mandatory";

    public static final String VARIENT_NULL = "Varient is mandatory";

    public static final String SHORT_DESCRIPTION_NULL = "Short description is mandatory";

    public static final String LONG_DESCRIPTION_NULL = "Long description is mandatory";

    public static final String PRODUCT_NOT_FOUND = "Product not found";

}
