package com.xproject.master.app.entrypoint;

import com.xproject.master.domain.usecase.client.GetClientUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private final GetClientUseCaseImpl useCase;

    public ClientController(final GetClientUseCaseImpl useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable String id) {
        String response;
        try {
            response = useCase.execute(id).toString();

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(response);
    }
}
