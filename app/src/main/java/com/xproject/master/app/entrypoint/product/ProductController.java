package com.xproject.master.app.entrypoint.product;

import com.xproject.master.app.dto.ProductDto;
import com.xproject.master.app.entrypoint.ApiInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController extends ApiInfo {

    ResponseEntity<ProductDto> findProductById(Long id);
    ResponseEntity<List<ProductDto>> findProductAll();
    ResponseEntity<ProductDto> saveProduct(ProductDto productDTO);
    ResponseEntity<List<ProductDto>> saveProductList(List<ProductDto> productDtoList);
    ResponseEntity<ProductDto> removeProductById(Long id);
    ResponseEntity<Void> removeProductList(List<ProductDto> productDtoList);
}
