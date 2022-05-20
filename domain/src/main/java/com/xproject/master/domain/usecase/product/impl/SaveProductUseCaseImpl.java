package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.client.SaveClientUseCase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SaveProductUseCaseImpl implements com.xproject.master.domain.usecase.product.SaveProductUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Override
    public Product execute(Product product) {
        return productDataProvider.saveProduct(product);
    }
}
