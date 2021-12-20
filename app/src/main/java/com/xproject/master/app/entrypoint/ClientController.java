package com.xproject.master.app.entrypoint;

import com.xproject.master.domain.usecase.user.GetClientUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientController {

    public GetClientUseCaseImpl useCase;

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
