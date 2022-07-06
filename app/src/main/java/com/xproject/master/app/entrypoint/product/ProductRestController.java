package com.xproject.master.app.entrypoint.product;

import com.xproject.master.app.dto.ProductDto;
import com.xproject.master.app.mappers.ProductMapper;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.product.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "product")
@AllArgsConstructor
public class ProductRestController implements ProductController {

    private FindProductAllUseCase findProductAllUseCase;
    private FindProductByIdUseCase findClientByIdUseCase;
    private CreateProductUseCase createProductUseCase;
    private CreateProductListUseCase createProductListUseCase;
    private DeleteProductByIdUseCase deleteProductByIdUseCase;
    private DeleteProductListUseCase deleteClientListUseCase;
    private UpdateProductUseCase updateProductUseCase;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long id) {
        if(Objects.nonNull(id)) {
            final Product product = findClientByIdUseCase.execute(id);
            final ProductDto productDto = ProductMapper.INSTANCE.productToProductDto(product);
            return ResponseEntity.ok().body(productDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> findProductAll() {
        final List<Product> productList = findProductAllUseCase.execute();
        final List<ProductDto> productDtoList = ProductMapper.INSTANCE.productListToProductDtoList(productList);
        return ResponseEntity.ok().body(productDtoList);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDTO) {
        if(Objects.nonNull(productDTO)) {
            final Product product = ProductMapper.INSTANCE.productDtoToProduct(productDTO);
            final Product productResponse = createProductUseCase.execute(product);
            final ProductDto productDtoResponse = ProductMapper.INSTANCE.productToProductDto(productResponse);
            return ResponseEntity.created(URI.create("/product/" + productDtoResponse.getId())).body(productDtoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> createProductList(@RequestBody List<ProductDto> productDtoList) {
        if(Objects.nonNull(productDtoList)) {
            final List<Product> productList = ProductMapper.INSTANCE.productDtoListToProductList(productDtoList);
            final List<Product> propductListResponse = createProductListUseCase.execute(productList);
            final List<ProductDto> clientDTOListResponse = ProductMapper.INSTANCE.productListToProductDtoList(propductListResponse);
            return ResponseEntity.created(URI.create("/client/list")).body(clientDTOListResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        if(Objects.nonNull(id)) {
            deleteProductByIdUseCase.execute(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProductList(@RequestBody List<ProductDto> productDtoList) {
        if(Objects.nonNull(productDtoList)) {
            final List<Product> productList = ProductMapper.INSTANCE.productDtoListToProductList(productDtoList);
            deleteClientListUseCase.execute(productList);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDTO){
       if(Objects.nonNull(productDTO)){
           final Product product = ProductMapper.INSTANCE.productDtoToProduct(productDTO);
           final Product productResponse = updateProductUseCase.execute(id, product);
           final ProductDto productDtoResponse = ProductMapper.INSTANCE.productToProductDto(productResponse);
           return ResponseEntity.ok().body(productDtoResponse);
       }
       return ResponseEntity.notFound().build();
    }
}
