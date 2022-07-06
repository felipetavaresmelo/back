package com.xproject.master.app.entrypoint.product;

import com.xproject.master.app.dto.ProductDto;
import com.xproject.master.app.entrypoint.ApiInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController extends ApiInfo {

    ResponseEntity<ProductDto> findProductById(Long id);
    ResponseEntity<List<ProductDto>> findProductAll();
    ResponseEntity<ProductDto> createProduct(ProductDto productDTO);
    ResponseEntity<List<ProductDto>> createProductList(List<ProductDto> productDtoList);
    ResponseEntity<Void> deleteProductById(Long id);
    ResponseEntity<Void> deleteProductList(List<ProductDto> productDtoList);
    ResponseEntity<ProductDto> updateProduct(Long id, ProductDto productDTO);
}
