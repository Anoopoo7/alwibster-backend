/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lxiya.xendercart.core.PageView;
import com.lxiya.xendercart.core.UserContext;
import com.lxiya.xendercart.core.errors.ProductErrors;
import com.lxiya.xendercart.product.helper.ProductHelper;
import com.lxiya.xendercart.product.model.request.CreateProductRequest;
import com.lxiya.xendercart.product.model.request.EditProductRequest;
import com.lxiya.xendercart.product.model.view.ProductView;
import com.lxiya.xendercart.product.persistance.dao.ProductDao;
import com.lxiya.xendercart.product.persistance.entity.Product;
import com.lxiya.xendercart.product.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product saveProduct(Product product) {
        product.setUpdatedDate(new Date());
        product.setModifiedBy(UserContext.user().getEmail());
        log.info("D045C5A8-B72D-47AF-840C-110595DB1560 saving product : {}", product);
        return productDao.getProductRepository().save(product);
    }

    @Override
    public ProductView createProduct(final CreateProductRequest createProductRequest) {
        log.info("E94805C3-D0F9-4BE3-8D24-FE6667BC7FB6 creating product with details {}", createProductRequest);
        Product product = ProductHelper.constructProductFromCreateProductRequest(createProductRequest);
        log.info("0FB73972-02F9-4494-B3C3-005F445EFBE9 saving product: {}", product);
        return ProductHelper.transformProductToView(this.saveProduct(product));
    }

    @Override
    public Product getProductById(String productId) {
        if (null == productId) {
            throw new RuntimeException(ProductErrors.PRODUCT_ID_NULL);
        }
        Optional<Product> optionalProduct = productDao.getProductRepository().findByIdAndEnabled(productId, true);
        if (optionalProduct.isEmpty()) {
            log.error("C9986154-3AD5-4045-A4B2-8A4310517E8E No products found for the id : {}", productId);
            return null;
        }
        return optionalProduct.get();
    }

    @Override
    public ProductView getProduct(String id) {
        Product product = this.getProductById(id);
        if (null == product) {
            throw new RuntimeException(ProductErrors.PRODUCT_NOT_FOUND);
        }
        log.info("4FF3C9D8-72E1-469D-B92C-34199997A548 fetched product {} for the product id {}", product,
                id);
        return ProductHelper.transformProductToView(product);
    }

    @Override
    public PageView<ProductView> getProducts(String searchTerm, Pageable pageable) {
        log.info("13299146-D7FB-4C3B-B6D4-CC0673A94E84 fetching products with searchTerm : {}", searchTerm);
        PageView<Product> productsPage = productDao.getProductRepository().searchProducts(searchTerm, pageable);
        List<ProductView> productViews = ProductHelper.transformProductsToViews(productsPage.getData());
        return new PageView<ProductView>(productViews, productsPage);
    }

    @Override
    public ProductView toggleProductStatus(String id) {
        log.info("261FF8C4-A91E-423F-844B-8379C1AA3A26 editing product status if id : {}", id);
        Product product = this.getProductById(id);
        if (null == product) {
            throw new RuntimeException(ProductErrors.PRODUCT_NOT_FOUND);
        }
        product.setActive(!product.isActive());
        return ProductHelper.transformProductToView(this.saveProduct(product));
    }

    @Override
    public ProductView editProduct(String id, EditProductRequest editProductRequest) {
        log.info("50561FCB-702D-4607-AA03-BA398515FBFC editing product of id : {} with details : {}", id,
                editProductRequest);
        Product product = this.getProductById(id);
        if (null == product) {
            throw new RuntimeException(ProductErrors.PRODUCT_NOT_FOUND);
        }
        ProductHelper.populateProductFromEditRequest(product, editProductRequest);
        return ProductHelper.transformProductToView(this.saveProduct(product));
    }

}
