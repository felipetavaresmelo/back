package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientController {

    ResponseEntity<ClientDTO> findClientById(Long id);
    ResponseEntity<List<ClientDTO>> findClientAll();
    ResponseEntity<ClientDTO> saveClient(ClientDTO clientDTO);
    ResponseEntity<List<ClientDTO>> saveClientList(List<ClientDTO> clientDTOList);
}
