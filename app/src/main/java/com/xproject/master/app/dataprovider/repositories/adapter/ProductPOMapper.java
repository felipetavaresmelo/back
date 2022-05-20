package com.xproject.master.app.dataprovider.repositories.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ProductPO;
import com.xproject.master.domain.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPOMapper {

    ProductPOMapper INSTANCE = Mappers.getMapper(ProductPOMapper.class);

    ProductPO ofProduct(Product product);

    List<ProductPO> ofProductList(List<Product> clientList);
}
