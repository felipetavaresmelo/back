package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.ReadProductByIdUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.NoSuchElementException;
import java.util.Objects;

@Named
public class ReadProductByIdUseCaseImpl implements ReadProductByIdUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Override
    public Product execute(Long id) {
        final Product productFound = productDataProvider.readProductById(id);
        if(Objects.nonNull(productFound) && Objects.nonNull(productFound.getId())){
            return productFound;
        }else{
            throw new NoSuchElementException("Product not found!");
        }
    }
}
