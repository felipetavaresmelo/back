package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FindProductByIdUseCaseImpl implements com.xproject.master.domain.usecase.product.FindProductByIdUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Override
    public Product execute(Long id) {
        return productDataProvider.findProductById(id);
    }
}
