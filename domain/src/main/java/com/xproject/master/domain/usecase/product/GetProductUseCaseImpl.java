package com.xproject.master.domain.usecase.product;

import com.xproject.master.domain.entity.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductUseCaseImpl {

    public Product execute (String id) {

        return (new Product(id, "nome do produto"));
    }
}
