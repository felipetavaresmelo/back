package com.xproject.master.domain.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public final class ProductCategory {

    private String name;
    private List<Product> products;
}
