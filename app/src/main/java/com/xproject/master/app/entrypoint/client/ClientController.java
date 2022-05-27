package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientController {

    ResponseEntity<ClientDto> findClientById(Long id);
    ResponseEntity<List<ClientDto>> findClientAll();
    ResponseEntity<ClientDto> saveClient(ClientDto clientDTO);
    ResponseEntity<List<ClientDto>> saveClientList(List<ClientDto> clientDtoList);
}
