package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class FindProductAllUseCaseImpl implements com.xproject.master.domain.usecase.product.FindProductAllUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Override
    public List<Product> execute() {
        return productDataProvider.findProductList();
    }
}
