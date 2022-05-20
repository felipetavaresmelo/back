package com.xproject.master.app.dataprovider;

import com.xproject.master.app.adapter.ProductMapper;
import com.xproject.master.app.dataprovider.repositories.ProductJpaRepository;
import com.xproject.master.app.dataprovider.repositories.adapter.ProductPOMapper;
import com.xproject.master.app.dataprovider.repositories.persistent.ProductPO;
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
    public Product findProductById(Long id) {
        final ProductPO productPOById = repository.findById(id).orElse(new ProductPO());
        return ProductMapper.INSTANCE.ofProductPO(productPOById);
    }

    public List<Product> findProductListByIdList (List<Long> idList) {
        final List<ProductPO> productPOListById = repository.findAllById(idList);
        return ProductMapper.INSTANCE.ofProductPOList(productPOListById);
    }

    @Override
    public List<Product> findProductList() {
        final List<ProductPO> productPOList = repository.findAll();
        if(productPOList.isEmpty()){
            return new ArrayList<>();
        }
        return ProductMapper.INSTANCE.ofProductPOList(productPOList);
    }

    @Override
    public Product saveProduct (Product product) {
        final ProductPO productPOListIn = ProductPOMapper.INSTANCE.ofProduct(product);
        final ProductPO productPOListOut = repository.save(productPOListIn);
        return ProductMapper.INSTANCE.ofProductPO(productPOListOut);
    }

    @Override
    public List<Product> saveProductList (List<Product> productList) {
        final List<ProductPO> producPOListIn = ProductPOMapper.INSTANCE.ofProductList(productList);
        final List<ProductPO> productPOListOut = repository.saveAll(producPOListIn);
        return ProductMapper.INSTANCE.ofProductPOList(productPOListOut);
    }

    @Override
    public void removeProductById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void removeProductList(List<Product> productList) {
        final List<ProductPO> productPOList = ProductPOMapper.INSTANCE.ofProductList(productList);
        repository.deleteAll(productPOList);
    }
}
