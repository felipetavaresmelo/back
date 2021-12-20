package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.product.Product;

public interface ProductDataProvider {
    Product getProductById(String id);
}
