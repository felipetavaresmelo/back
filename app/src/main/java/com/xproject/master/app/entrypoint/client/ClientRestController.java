package com.xproject.master.app.entrypoint.client;

import com.google.gson.Gson;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.entity.product.Product;
import com.xproject.master.domain.usecase.client.GetClientUseCase;
import com.xproject.master.domain.usecase.client.PostClientUseCase;
import com.xproject.master.domain.usecase.client.PutClientUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
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

    @Inject
    final PutClientUseCase putClientUseCase;

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postClient(@RequestBody Client client) {
        String status;
        try {
            status = postClientUseCase.postClient(client).getName();

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(status);
    }

    @Override
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getClientById(@PathVariable String id) {
        Gson gson = new Gson();
        String response;
        try {
            response = gson.toJson(getClientUseCase.getClientById(id));
            if (response == null) {
                throw new Exception("Não encontrado.");
            }
        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(response);
    }

    @Override
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> putClient(@RequestBody Client client) {

        try {
            putClientUseCase.putClient(client);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
