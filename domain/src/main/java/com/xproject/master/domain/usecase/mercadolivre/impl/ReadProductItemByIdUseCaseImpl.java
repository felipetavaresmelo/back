package com.xproject.master.domain.usecase.mercadolivre.impl;

import com.xproject.master.domain.dataprovider.MercadoLivreDataProvider;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.mercadolivre.ReadProductItemByIdUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.NoSuchElementException;
import java.util.Objects;

@Named
public class ReadProductItemByIdUseCaseImpl implements ReadProductItemByIdUseCase {

    @Inject
    private MercadoLivreDataProvider mercadoLivreDataProvider;

    @Override
    public Product execute (String id){
        final Product product = mercadoLivreDataProvider.getProductItem(id);
        if(Objects.nonNull(product) && Objects.nonNull(product.getId())){
            return product;
        }else{
            throw new NoSuchElementException("Product item not found!");
        }
    }
}