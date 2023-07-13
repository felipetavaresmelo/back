package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.entity.product.Product;

public interface ReadProductByIdUseCase {
    Product execute(Long id);
}