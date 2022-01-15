package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.exception.BaseException;
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

    private ClientRegisterUseCase useCase;

    @Inject
    public ClientRestController(ClientRegisterUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client response = null;
        try {
            response = useCase.addClient(client);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Error", e.getCause().toString())
                    .body(response);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @Override
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client clientById = null;
        try {
            clientById = useCase.getClientById(id);
            if (clientById == null) {
                throw new BaseException("Não encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(clientById);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientById);
    }

    @Override
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> putClient(@RequestBody Client client) {
        try {
            useCase.putClient(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
    }

    @Override
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> patchClient(@RequestBody Client client) {
        try {
            useCase.patchClient(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
