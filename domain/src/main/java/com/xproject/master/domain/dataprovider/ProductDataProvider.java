package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.product.Product;

import java.util.List;

public interface ProductDataProvider {
    Product findProductById(Long id);

    List<Product> findProductList();

    List<Product> findProductListByIdList (List<Long> idList);

    Product saveProduct (Product product);

    List<Product> saveProductList(List<Product> productList);

    void removeProductById(Long id);

    void removeProductList(List<Product> productList);

}
