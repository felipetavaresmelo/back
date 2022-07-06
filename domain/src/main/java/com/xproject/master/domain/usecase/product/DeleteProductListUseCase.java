package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.entity.product.Product;

import java.util.List;

public interface DeleteProductListUseCase {
    void execute(List<Product> productList);
}
