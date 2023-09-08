/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.model.request;

import java.util.List;

import javax.validation.constraints.Pattern;

import com.lxiya.xendercart.core.errors.ProductErrors;
import com.lxiya.xendercart.core.patterns.Patters;
import com.lxiya.xendercart.product.model.ProductMedias;

import lombok.Data;

@Data
public class EditProductRequest {

    @Pattern(regexp = Patters.STRING_LIMIT_100, message = ProductErrors.NAME_LENGTH_LIMIT_EXCEEDS)
    private String name;

    private String brandId;

    private String categoryId;

    private List<ProductMedias> defaultMedias;

    private List<String> addOns;

    private List<String> childProducts;

    private List<String> relatedProducts;

    private Integer rating;

    @Pattern(regexp = Patters.DATE_REQEX, message = ProductErrors.DATE_INVALID)
    private String saleStartDate;

    @Pattern(regexp = Patters.DATE_REQEX, message = ProductErrors.DATE_INVALID)
    private String saleEndDate;
}
