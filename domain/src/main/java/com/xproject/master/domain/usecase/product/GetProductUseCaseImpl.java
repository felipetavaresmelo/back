package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductUseCaseImpl implements GetProductUseCase {

    private final ProductDataProvider productDataProvider;

    @Override
    public Product execute(String id) {
        return (productDataProvider.getProductById(id)
        );
    }
}
