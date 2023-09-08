/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.model.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lxiya.xendercart.core.errors.SkuErrors;
import com.lxiya.xendercart.product.model.ProductMedias;

import lombok.Data;

@Data
public class CreateSkuRequest {

    @NotBlank(message = SkuErrors.PRODUCT_ID_NULL)
    private String productId;

    @NotBlank(message = SkuErrors.LOCATION_NULL)
    private String location;

    @NotNull(message = SkuErrors.STOCK_NULL)
    private int stock;

    private boolean hotStock;

    @NotNull(message = SkuErrors.LIST_PRICE_NULL)
    private int listPrice;

    @NotNull(message = SkuErrors.SALE_PRICE_NULL)
    private int salePrice;

    @NotBlank(message = SkuErrors.VARIENT_NULL)
    private String varient;

    @NotBlank(message = SkuErrors.SHORT_DESCRIPTION_NULL)
    private String shortDescription;

    private boolean isDefault;

    private String keyWords;

    @NotBlank(message = SkuErrors.LONG_DESCRIPTION_NULL)
    private String longDescription;

    private List<ProductMedias> medias;

    private boolean customImages;
}
