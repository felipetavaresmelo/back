package com.xproject.master.domain.usecase.mercadolivre;

import com.xproject.master.domain.entity.product.Product;

public interface ReadProductItemByIdUseCase {
    Product execute (String id);
}
