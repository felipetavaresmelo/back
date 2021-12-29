package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.product.Product;

public interface ProductDataProvider {
    Product getProductById(String id);

    Boolean postProduct(Product client);

    void putProduct(Product client);

    void patchProduct(Product client);

    Boolean deleteProduct(Product client);
}
