package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClientController {
//    ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO client);

    ResponseEntity<List<ClientDTO>> getClients();
//
//    ResponseEntity<ClientDTO> getClientById(@PathVariable Long id);
//
//    ResponseEntity<HttpStatus> putClient(@RequestBody Client client);
//
//    ResponseEntity<HttpStatus> patchClient(@RequestBody Client client);
}
