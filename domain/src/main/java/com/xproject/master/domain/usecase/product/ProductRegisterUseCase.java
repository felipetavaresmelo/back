package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.entity.product.Product;

public interface ProductRegisterUseCase {

    Product getProductById(String id);

    Product saveProduct(Product product);
}
