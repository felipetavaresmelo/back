package com.xproject.master.app.entrypoint.client;

import com.google.gson.Gson;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.ClientRegisterUseCase;
import lombok.RequiredArgsConstructor;
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
    final ClientRegisterUseCase useCase;

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postClient(@RequestBody Client client) {
        Gson gson = new Gson();
        Client  response;
        try {
            response = useCase.postClient(client);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getCause().toString());
        }
        return ResponseEntity.ok(gson.toJson(response));
    }

    @Override
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getClientById(@PathVariable String id) {
        Gson gson = new Gson();
        String response;
        try {
            response = gson.toJson(useCase.getClientById(id));
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
            useCase.putClient(client);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> patchClient(@RequestBody Client client) {
        try {
            useCase.patchClient(client);
        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
