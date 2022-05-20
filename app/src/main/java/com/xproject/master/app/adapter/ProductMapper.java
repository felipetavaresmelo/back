package com.xproject.master.app.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ProductPO;
import com.xproject.master.app.dto.ProductDTO;
import com.xproject.master.domain.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product ofProductPO (ProductPO productPO);

    Product ofProductDTO (ProductDTO productDTO);

    List<Product> ofProductPOList(List<ProductPO> productPOList);

    List<Product> ofProductDTOList (List<ProductDTO> productDTOList);

}
