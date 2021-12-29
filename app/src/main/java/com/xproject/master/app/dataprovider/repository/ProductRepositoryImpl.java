package com.xproject.master.app.dataprovider.repository;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;

import javax.inject.Named;

@Named
public class ProductRepositoryImpl implements ProductDataProvider {
    @Override
    public Product getProductById(String id) {
        return Product.builder()
                .productId(id)
                .name("Nome do produto " + id)
                .build();
    }

    @Override
    public Boolean postProduct(Product client) {
        return null;
    }

    @Override
    public void putProduct(Product client) {

    }

    @Override
    public void patchProduct(Product client) {

    }

    @Override
    public Boolean deleteProduct(Product client) {
        return null;
    }
}
