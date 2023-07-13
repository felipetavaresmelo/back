package com.xproject.master.app.dataprovider.repository;

import com.xproject.master.app.dataprovider.repository.jpa.ProductJpaRepository;
import com.xproject.master.app.dataprovider.repository.jpa.po.ProductPo;
import com.xproject.master.app.mappers.ProductMapper;
import com.xproject.master.domain.dataprovider.ProductDataProvider;
import com.xproject.master.domain.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDataProviderImpl implements ProductDataProvider {

    @Autowired
    private ProductJpaRepository repository;

    @Override
    public Product readProductById(Long id) {
        final ProductPo productPoById = repository.findById(id).orElse(new ProductPo());
        return ProductMapper.INSTANCE.productPoToProduct(productPoById);
    }

    public List<Product> readProductListByIdList(List<Long> idList) {
        final List<ProductPo> productPoListById = repository.findAllById(idList);
        return ProductMapper.INSTANCE.productPoListToProductList(productPoListById);
    }

    @Override
    public List<Product> readProductList() {
        final List<ProductPo> productPoList = repository.findAll();
        if(productPoList.isEmpty()){
            return new ArrayList<>();
        }
        return ProductMapper.INSTANCE.productPoListToProductList(productPoList);
    }

    @Override
    public Product saveProduct (Product product) {
        final ProductPo productPoIn = ProductMapper.INSTANCE.productToProductPo(product);
        final ProductPo productPoOut = repository.save(productPoIn);
        return ProductMapper.INSTANCE.productPoToProduct(productPoOut);
    }

    @Override
    public List<Product> saveProductList (List<Product> productList) {
        final List<ProductPo> productPOListIn = ProductMapper.INSTANCE.productListToProductPoList(productList);
        final List<ProductPo> productPoListOut = repository.saveAll(productPOListIn);
        return ProductMapper.INSTANCE.productPoListToProductList(productPoListOut);
    }

    @Override
    public void removeProductById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void removeProductList(List<Product> productList) {
        final List<ProductPo> productPoList = ProductMapper.INSTANCE.productListToProductPoList(productList);
        repository.deleteAll(productPoList);
    }

}
