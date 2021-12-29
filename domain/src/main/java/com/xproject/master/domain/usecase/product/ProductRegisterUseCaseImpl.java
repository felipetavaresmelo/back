package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import lombok.AllArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@AllArgsConstructor
public class ProductRegisterUseCaseImpl implements ProductRegisterUseCase {

    @Inject
    private final ProductDataProvider productDataProvider;

    @Override
    public Product getProductById(String id) {
        return (productDataProvider.getProductById(id));
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }
}
