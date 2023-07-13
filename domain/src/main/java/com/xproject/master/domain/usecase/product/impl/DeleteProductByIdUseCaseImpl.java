package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.DeleteProductByIdUseCase;
import com.xproject.master.domain.usecase.product.ReadProductByIdUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.NoSuchElementException;
import java.util.Objects;

@Named
public class DeleteProductByIdUseCaseImpl implements DeleteProductByIdUseCase {

    @Inject
    private ProductDataProvider productDataProvider;
    @Inject
    private ReadProductByIdUseCase readProductByIdUseCase;


    @Override
    public void execute(Long id) {
        final Product product = readProductByIdUseCase.execute(id);
        if(Objects.nonNull(product) && Objects.nonNull(product.getId())) {
            productDataProvider.removeProductById(id);
        } else {
            throw new NoSuchElementException("Find product by id not found");
        }
    }
}
