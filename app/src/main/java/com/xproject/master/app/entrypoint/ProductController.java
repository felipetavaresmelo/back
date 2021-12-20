package com.xproject.master.app.entrypoint;

import com.xproject.master.domain.entity.Product;
import com.xproject.master.domain.usecase.product.GetProductUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final GetProductUseCaseImpl getProductUseCaseImpl;

    @GetMapping("/product/{id}")
    public ResponseEntity<String> geProductById(@PathVariable String id) {
        final Product response;
        try {
            response = getProductUseCaseImpl.execute(id);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(response.toString());
    }
}
