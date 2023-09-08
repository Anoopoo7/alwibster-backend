/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.controller;

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

import com.lxiya.xendercart.core.PageView;
import com.lxiya.xendercart.product.model.request.CreateProductRequest;
import com.lxiya.xendercart.product.model.request.EditProductRequest;
import com.lxiya.xendercart.product.model.view.ProductView;
import com.lxiya.xendercart.product.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Create product
     * 
     * @param createProductRequest
     * @return ProductView
     */
    @PostMapping
    @PreAuthorize("hasAuthority('XEN_CRT_PRD')")
    public ProductView createProduct(@Valid @RequestBody final CreateProductRequest createProductRequest) {
        log.info("17B2F987-ED79-4550-939A-FCDEEA1B027B creating product with details : {}", createProductRequest);
        return productService.createProduct(createProductRequest);
    }

    /**
     * Find product
     * 
     * @param id
     * @return ProductView
     */
    @GetMapping("/id/{id}")
    @PreAuthorize("hasAuthority('XEN_VWE_PRD')")
    public ProductView getProduct(@PathVariable final String id) {
        log.info("238CDB02-C265-41C8-AB3C-6F9FD60C6A3C fetching product with id : {}", id);
        return productService.getProduct(id);
    }

    /**
     * Toggle product status
     * 
     * @param id
     * @return ProductView
     */
    @PatchMapping("/id/{id}")
    @PreAuthorize("hasAuthority('XEN_EDT_PRD')")
    public ProductView toggleProductStatus(@PathVariable final String id) {
        log.info("238CDB02-C265-41C8-AB3C-6F9FD60C6A3C editing product status of id : {}", id);
        return productService.toggleProductStatus(id);
    }

    /**
     * Edit product
     * 
     * @param id
     * @param editProductRequest
     * @return ProductView
     */
    @PutMapping("/edit/id/{id}")
    @PreAuthorize("hasAuthority('XEN_EDT_PRD')")
    public ProductView editProduct(@PathVariable final String id,
            @Valid @RequestBody final EditProductRequest editProductRequest) {
        log.info("238CDB02-C265-41C8-AB3C-6F9FD60C6A3C editing product of id : {} with details : {}", id,
                editProductRequest);
        return productService.editProduct(id, editProductRequest);
    }

    /**
     * List/search product
     * 
     * @param searchTerm
     * @param pageable
     * @return PageView<ProductView>
     */
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('XEN_VWE_PRD')")
    public PageView<ProductView> getProducts(@RequestParam(required = false) final String searchTerm,
            final Pageable pageable) {
        log.info("77B1C551-1077-4EEF-9758-E0D5BD68F064 fetching products with searchTerm : {}", searchTerm);
        return productService.getProducts(searchTerm, pageable);
    }

}
