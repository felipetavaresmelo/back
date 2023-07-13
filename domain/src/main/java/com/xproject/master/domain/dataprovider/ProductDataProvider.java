package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.product.Product;

import java.util.List;

public interface ProductDataProvider {
    Product readProductById(Long id);

    List<Product> readProductList();

    List<Product> readProductListByIdList(List<Long> idList);

    Product saveProduct (Product client);

    List<Product> saveProductList(List<Product> productList);

    void removeProductById(Long id);

    void removeProductList(List<Product> productList);

}
