package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.entity.product.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductUseCaseImpl {

    public Product execute (String id) {

        return (Product.builder()
                .productId(id)
                .name("nome do produto")
                .build()
        );
    }
}
