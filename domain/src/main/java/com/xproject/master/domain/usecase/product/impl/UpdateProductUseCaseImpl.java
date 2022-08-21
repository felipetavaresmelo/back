package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.FindProductByIdUseCase;
import com.xproject.master.domain.usecase.product.UpdateProductUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.NoSuchElementException;
import java.util.Objects;

@Named
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    @Inject
    private ProductDataProvider productDataProvider;

    @Inject
    private FindProductByIdUseCase findProductByIdUseCase;

    @Override
    public Product execute(Long id, Product product) {
        if(Objects.isNull(product.getId()) || (!id.equals(product.getId()))){
            throw new NoSuchElementException("Invalid Id.");
        }
        final Product productFound = findProductByIdUseCase.execute(id);
        if(Objects.nonNull(productFound) && Objects.nonNull(productFound.getId())){
            return productDataProvider.saveProduct(product);
        }else{
            throw new NoSuchElementException("Find product by id not found");
        }
    }
}
