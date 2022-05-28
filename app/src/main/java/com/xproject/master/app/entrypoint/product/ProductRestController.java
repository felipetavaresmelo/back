package com.xproject.master.app.entrypoint.product;

import com.xproject.master.app.dto.ProductDto;
import com.xproject.master.app.mappers.ProductMapper;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.client.*;
import com.xproject.master.domain.usecase.product.FindProductAllUseCase;
import com.xproject.master.domain.usecase.product.FindProductByIdUseCase;
import com.xproject.master.domain.usecase.product.RemoveProductByIdUseCase;
import com.xproject.master.domain.usecase.product.SaveProductUseCase;
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
public class ProductRestController {

    private FindProductAllUseCase findProductAllUseCase;
    private FindProductByIdUseCase findClientByIdUseCase;
    private SaveProductUseCase saveProductUseCase;
    private SaveClientListUseCase saveClientListUseCase;
    private RemoveProductByIdUseCase removeProductByIdUseCase;
    private RemoveClientListUseCase removeClientListUseCase;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findIndex() {
        return ResponseEntity.notFound().build();
    }

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

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDTO) {
        if(Objects.nonNull(productDTO)) {
            final Product product = ProductMapper.INSTANCE.productDtoToProduct(productDTO);
            final Product productResponse = saveProductUseCase.execute(product);
            final ProductDto productDtoResponse = ProductMapper.INSTANCE.productToProductDto(productResponse);
            return ResponseEntity.created(URI.create("/product/" + productDtoResponse.getId())).body(productDtoResponse);
        }
        return ResponseEntity.notFound().build();
    }
//
//    @PutMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<ClientDTO>> saveClientList(@RequestBody List<ClientDTO> clientDTOList) {
//        if(Objects.nonNull(clientDTOList)) {
//            final List<Client> clientList = ClientMapper.INSTANCE.ofClientDTOList(clientDTOList);
//            final List<Client> clientListResponse = saveClientListUseCase.execute(clientList);
//            final List<ClientDTO> clientDTOListResponse = ClientDTOMapper.INSTANCE.ofClientList(clientListResponse);
//            return ResponseEntity.created(URI.create("/client/list")).body(clientDTOListResponse);
//        }
//        return ResponseEntity.notFound().build();
//    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> removeProductById(@PathVariable Long id) {
        if(Objects.nonNull(id)) {
            removeProductByIdUseCase.execute(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

//    @DeleteMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity removeClientList(@RequestBody List<ClientDTO> clientDTOList) {
//        if(Objects.nonNull(clientDTOList)) {
//            final List<Client> clientList = ClientMapper.INSTANCE.ofClientDTOList(clientDTOList);
//            removeClientListUseCase.execute(clientList);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}
