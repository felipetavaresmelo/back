package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.adapter.ClientMapper;
import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.adapter.ClientDTOMapper;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "client")
@AllArgsConstructor
public class ClientRestController implements ClientController {

    private FindClientAllUseCase findClientAllUseCase;
    private FindClientByIdUseCase findClientByIdUseCase;
    private SaveClientUseCase saveClientUseCase;
    private SaveClientListUseCase saveClientListUseCase;
    private RemoveClientByIdUseCase removeClientByIdUseCase;
    private RemoveClientListUseCase removeClientListUseCase;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> findIndex() {
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> findClientById(@PathVariable Long id) {
        if(Objects.nonNull(id)) {
            final Client client = findClientByIdUseCase.execute(id);
            final ClientDTO clientDTO = ClientDTOMapper.INSTANCE.ofClient(client);
            return ResponseEntity.ok().body(clientDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> findClientAll() {
        final List<Client> clientList = findClientAllUseCase.execute();
        final List<ClientDTO> clientDTOList = ClientDTOMapper.INSTANCE.ofClientList(clientList);
        return ResponseEntity.ok().body(clientDTOList);
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
        if(Objects.nonNull(clientDTO)) {
            final Client client = ClientMapper.INSTANCE.ofClientDTO(clientDTO);
            final Client clientResponse = saveClientUseCase.execute(client);
            final ClientDTO clientDTOResponse = ClientDTOMapper.INSTANCE.ofClient(clientResponse);
            return ResponseEntity.created(URI.create("/client/" + clientDTOResponse.getId())).body(clientDTOResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> saveClientList(@RequestBody List<ClientDTO> clientDTOList) {
        if(Objects.nonNull(clientDTOList)) {
            final List<Client> clientList = ClientMapper.INSTANCE.ofClientDTOList(clientDTOList);
            final List<Client> clientListResponse = saveClientListUseCase.execute(clientList);
            final List<ClientDTO> clientDTOListResponse = ClientDTOMapper.INSTANCE.ofClientList(clientListResponse);
            return ResponseEntity.created(URI.create("/client/list")).body(clientDTOListResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> removeClientById(@PathVariable Long id) {
        if(Objects.nonNull(id)) {
            removeClientByIdUseCase.execute(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeClientList(@RequestBody List<ClientDTO> clientDTOList) {
        if(Objects.nonNull(clientDTOList)) {
            final List<Client> clientList = ClientMapper.INSTANCE.ofClientDTOList(clientDTOList);
            removeClientListUseCase.execute(clientList);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
