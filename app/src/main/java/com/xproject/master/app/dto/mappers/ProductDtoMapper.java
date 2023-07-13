package com.xproject.master.app.dto.mappers;

import com.xproject.master.app.dto.ProductDto;
import com.xproject.master.domain.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    ProductDtoMapper INSTANCE = Mappers.getMapper(ProductDtoMapper.class);

    ProductDto productToProductDto (Product product);

}
