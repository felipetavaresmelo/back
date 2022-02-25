package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.adapter.ClientAdapter;
import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.exception.BaseException;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.register.client.RegisterClientUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
//@RequiredArgsConstructor
@RequestMapping(value = "/client")
public class ClientRestController implements ClientController {

    @Inject
    private RegisterClientUseCase useCase;

//    @Inject
//    public ClientRestController(ClientRegisterUseCase useCase) {
//        this.useCase = useCase;
//    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDto) {
        ClientDTO response = null;
        try {
            response = ClientAdapter.convertToDTO(useCase.addClient(ClientAdapter.convert(clientDto)));

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
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        ClientDTO clientDTOById = null;
        try {
            clientDTOById = new ClientDTO(useCase.getClientById(id));
            if (clientDTOById == null) {
                throw new BaseException("Não encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(clientDTOById);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientDTOById);
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
