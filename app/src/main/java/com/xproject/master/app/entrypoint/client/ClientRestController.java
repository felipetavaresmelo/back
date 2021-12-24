package com.xproject.master.app.entrypoint.client;

import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.client.GetClientUseCase;
import com.xproject.master.domain.usecase.client.PostClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "client")
public class ClientRestController implements ClientController {

    @Inject
    final GetClientUseCase getClientUseCase;

    @Inject
    final PostClientUseCase postClientUseCase;

    @Override
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getClientById(@PathVariable String id) {
        String response;
        try {
            response = getClientUseCase.getClientById(id).getName();

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postClient(@PathVariable String id, @RequestBody Client client) {
        String status = null;
        try {
            status = postClientUseCase.postClient(client).getName();

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(status);
    }
}
