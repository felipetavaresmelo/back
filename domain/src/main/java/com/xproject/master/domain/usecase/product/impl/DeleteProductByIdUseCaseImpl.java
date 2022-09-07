package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.DeleteProductByIdUseCase;
import com.xproject.master.domain.usecase.product.FindProductByIdUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.NoSuchElementException;
import java.util.Objects;

@Named
public class DeleteProductByIdUseCaseImpl implements DeleteProductByIdUseCase {

    @Inject
    private ProductDataProvider productDataProvider;
    @Inject
    private FindProductByIdUseCase findProductByIdUseCase;


    @Override
    public void execute(Long id) {
        final Product product = findProductByIdUseCase.execute(id);
        if(Objects.nonNull(product) && Objects.nonNull(product.getId())) {
            productDataProvider.removeProductById(id);
        } else {
            throw new NoSuchElementException("Find product by id not found");
        }
    }
}
