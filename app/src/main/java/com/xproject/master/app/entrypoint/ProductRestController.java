package com.xproject.master.app.entrypoint;

import com.xproject.master.domain.usecase.product.GetProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductRestController implements ProductController {

    private final GetProductUseCase useCase;

    @Override
    public ResponseEntity<String> geProductById(String id) {
        String response;
        try {
            response = useCase.execute(id).toString();

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(response);
    }
}
