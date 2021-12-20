package com.xproject.master.app.entrypoint;

import com.xproject.master.domain.usecase.product.GetProductUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private final GetProductUseCaseImpl useCase;

    public ProductController(GetProductUseCaseImpl useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<String> geProductById(@PathVariable String id) {
        final String response;
        try {
            response = useCase.execute(id).toString();

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(response);
    }
}
