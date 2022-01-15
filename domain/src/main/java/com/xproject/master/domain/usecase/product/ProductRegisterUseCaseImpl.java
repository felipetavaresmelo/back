package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ProductRegisterUseCaseImpl implements ProductRegisterUseCase {

    private ProductDataProvider productDataProvider;

    @Inject
    public ProductRegisterUseCaseImpl(ProductDataProvider productDataProvider) {
        this.productDataProvider = productDataProvider;
    }

    @Override
    public Product getProductById(String id) {
        return (productDataProvider.getProductById(id));
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }
}
