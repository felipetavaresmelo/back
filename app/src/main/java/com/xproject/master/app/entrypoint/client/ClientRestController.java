package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.adapter.ClientDTOAdapter;
import com.xproject.master.domain.usecase.register.client.RegisterClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "client")
public class ClientRestController implements ClientController {

    @Inject
    final RegisterClientUseCase useCase;

//    @Override
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDto) {
//        ClientDTO response = null;
//        try {
//            response = ClientDTOAdapter.convertClient(useCase.addClient(ClientAdapter.convertClientDTO(clientDto)));
//
//        } catch (Exception e) {
//            return ResponseEntity
//                    .internalServerError()
//                    .header("Error", e.getCause().toString())
//                    .body(response);
//        }
//        return ResponseEntity.ok().body(response);
//    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> getClients() {
        List<ClientDTO> clientDTOList = null;
        try {
            clientDTOList = ClientDTOAdapter.convertClientList(useCase.getClients());
            if (clientDTOList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(clientDTOList);
        }
        return ResponseEntity.ok().body(clientDTOList);
    }
//
//    @Override
//    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
//        ClientDTO clientDTOById = null;
//        try {
//            clientDTOById = ClientDTOAdapter.convertClient(useCase.getClientById(id));
//            if (clientDTOById == null) {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(clientDTOById);
//        }
//        return ResponseEntity.ok().body(clientDTOById);
//    }
//
//    @Override
//    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<HttpStatus> putClient(@RequestBody Client client) {
//        try {
//            useCase.putClient(client);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
//
//    @Override
//    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<HttpStatus> patchClient(@RequestBody Client client) {
//        try {
//            useCase.patchClient(client);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
}
