package com.xproject.master.domain.usecase.product.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.client.RemoveClientListUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class RemoveProductListUseCaseImpl implements com.xproject.master.domain.usecase.product.RemoveProductListUseCase {

    @Inject
    private ProductDataProvider productDataProvider;



    @Override
    public void execute(List<Product> productList) {
        if(!productList.isEmpty()) {
            final List<Long> idList = productList.stream().map(Product::getId).collect(Collectors.toList());
            if (!idList.isEmpty()) {
                final List<Product> productListByIdList = productDataProvider.findProductListByIdList(idList);
                productDataProvider.removeProductList(productListByIdList);
            }
        }
    }
}
