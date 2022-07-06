package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.CreateProductUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;

@Named
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Override
    public Product execute(Product product) {
        if(Objects.nonNull(product) && Objects.nonNull(product.getId())){
            throw new IllegalArgumentException("Id should not filled.");
        }
        return productDataProvider.saveProduct(product);
    }
}
