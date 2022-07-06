package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDto;
import com.xproject.master.app.mappers.ClientMapper;
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
    private CreateClientUseCase createClientUseCase;
    private UpdateClientUseCase updateClientUseCase;
    private CreateClientListUseCase createClientListUseCase;
    private DeleteClientByIdUseCase deleteClientByIdUseCase;
    private DeleteClientListUseCase deleteClientListUseCase;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> findClientById(@PathVariable Long id) {
        if(Objects.nonNull(id)) {
            final Client client = findClientByIdUseCase.execute(id);
            final ClientDto clientDTO = ClientMapper.INSTANCE.clientToClientDto(client);
            return ResponseEntity.ok().body(clientDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDto>> findClientAll() {
        final List<Client> clientList = findClientAllUseCase.execute();
        final List<ClientDto> clientDtoList = ClientMapper.INSTANCE.clientListToClientDtoList(clientList);
        return ResponseEntity.ok().body(clientDtoList);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDTO) {
        if(Objects.nonNull(clientDTO)) {
            final Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDTO);
            final Client clientResponse = createClientUseCase.execute(client);
            final ClientDto clientDtoResponse = ClientMapper.INSTANCE.clientToClientDto(clientResponse);
            return ResponseEntity.created(URI.create("/client/" + clientDtoResponse.getId())).body(clientDtoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDto>> createClientList(@RequestBody List<ClientDto> clientDtoList) {
        if(Objects.nonNull(clientDtoList)) {
            final List<Client> clientList = ClientMapper.INSTANCE.clientDtoListToClientList(clientDtoList);
            final List<Client> clientListResponse = createClientListUseCase.execute(clientList);
            final List<ClientDto> clientDtoListResponse = ClientMapper.INSTANCE.clientListToClientDtoList(clientListResponse);
            return ResponseEntity.created(URI.create("/client/list")).body(clientDtoListResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> deleteClientById(@PathVariable Long id) {
        if(Objects.nonNull(id)) {
            deleteClientByIdUseCase.execute(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteClientList(@RequestBody List<ClientDto> clientDtoList) {
        if(Objects.nonNull(clientDtoList)) {
            final List<Client> clientList = ClientMapper.INSTANCE.clientDtoListToClientList(clientDtoList);
            deleteClientListUseCase.execute(clientList);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDTO) {
        if(Objects.nonNull(clientDTO)) {
            final Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDTO);
            final Client clientResponse = updateClientUseCase.execute(id, client);
            final ClientDto clientDtoResponse = ClientMapper.INSTANCE.clientToClientDto(clientResponse);
            return ResponseEntity.ok().body(clientDtoResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
