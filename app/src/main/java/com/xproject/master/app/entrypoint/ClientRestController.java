package com.xproject.master.app.entrypoint;

import com.xproject.master.domain.usecase.client.GetClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "client")
public class ClientRestController implements ClientController {

    @Inject
    final GetClientUseCase useCase;

    @Override
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserById(@PathVariable String id) {
        String response;
        try {
            response = useCase.execute(id).getName();

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(response);
    }
}
