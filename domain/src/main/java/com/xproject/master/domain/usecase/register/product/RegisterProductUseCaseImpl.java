package com.xproject.master.domain.usecase.register.product;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegisterProductUseCaseImpl implements RegisterProductUseCase {

    private ProductDataProvider productDataProvider;

    @Inject
    public RegisterProductUseCaseImpl(ProductDataProvider productDataProvider) {
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
