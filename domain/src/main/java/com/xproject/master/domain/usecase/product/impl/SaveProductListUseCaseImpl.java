package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.SaveProductListUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SaveProductListUseCaseImpl implements SaveProductListUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Override
    public List<Product> execute(List<Product> productList) {
        return productDataProvider.saveProductList(productList);
    }
}
