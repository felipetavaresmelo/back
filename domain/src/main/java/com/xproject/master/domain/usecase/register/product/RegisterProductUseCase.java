package com.xproject.master.domain.usecase.register.product;

import com.xproject.master.domain.entity.product.Product;

public interface RegisterProductUseCase {

    Product getProductById(String id);

    Product saveProduct(Product product);
}
