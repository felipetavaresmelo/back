package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.CreateProductListUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CreateProductListUseCaseImpl implements CreateProductListUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Override
    public List<Product> execute(List<Product> productList) {
        for(Product prod: productList){
            prod.setId(null);
        }
        return productDataProvider.saveProductList(productList);
    }
}
