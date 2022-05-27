package com.xproject.master.app.mappers;

import com.xproject.master.app.dataprovider.jpa.po.ProductPo;
import com.xproject.master.app.dto.ProductDto;
import com.xproject.master.domain.entity.product.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto (Product product);

    ProductPo productToProductPo (Product product);

    List<ProductPo> productListToProductPoList(List<Product> productList);

    Product productPoToProduct(ProductPo productPO);

    ProductDto productPoToProductDto(ProductPo productPo);

    List<Product> productPoListToProductList(List<ProductPo> productPoList);

    Product productDtoToProduct(ProductDto productDTO);

    ProductPo productDtoToProductPo(ProductDto productDto);

    List<Product> productDtoListToProductList(List<ProductDto> productDtoList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductPoFromProductDto(ProductDto productDto, @MappingTarget ProductPo productPo);
}
