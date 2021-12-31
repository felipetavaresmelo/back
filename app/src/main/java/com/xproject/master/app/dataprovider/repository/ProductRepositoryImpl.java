package com.xproject.master.app.dataprovider.repository;

import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class ProductRepositoryImpl implements ProductDataProvider {

    List<Product> productList;

    public ProductRepositoryImpl() {
        this.productList = new ArrayList<>();
        this.productList.add(Product.builder().productId("1").name("Nome do produto 1").build());
        this.productList.add(Product.builder().productId("2").name("Nome do produto 2").build());
        this.productList.add(Product.builder().productId("3").name("Nome do produto 3").build());
    }

    @Override
    public Product getProductById(String id) {
        return productList.stream()
                .filter(product -> product.getProductId().equals(id)).findFirst()
                .orElse(new Product());
    }

    @Override
    public Boolean postProduct(Product client) {
        return productList.add(client);
    }

    @Override
    public void putProduct(Product product) {
        productList = productList.stream()
                .map(p -> Boolean.TRUE.equals(p.isEqual(product)) ? product : p).collect(Collectors.toList());
    }

    @Override
    public void patchProduct(Product product) {
        productList = productList.stream()
                .map(p -> Boolean.TRUE.equals(p.isEqual(product)) ? product : p).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteProduct(Product product) {
        return productList.remove(product);
    }
}
