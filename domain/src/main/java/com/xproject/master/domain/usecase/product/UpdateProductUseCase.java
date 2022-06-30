package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.entity.product.Product;

public interface UpdateProductUseCase {
    Product execute(Product product);
}
