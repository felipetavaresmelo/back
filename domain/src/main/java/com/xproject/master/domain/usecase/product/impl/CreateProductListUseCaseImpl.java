package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.CreateProductListUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

@Named
public class CreateProductListUseCaseImpl implements CreateProductListUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Override
    public List<Product> execute(List<Product> productList) {
        for(Product prod: productList){
            if(Objects.nonNull(prod) && Objects.nonNull(prod.getId())){
                throw new IllegalArgumentException("Id should not filled.");
            }
        }
        return productDataProvider.saveProductList(productList);
    }
}
