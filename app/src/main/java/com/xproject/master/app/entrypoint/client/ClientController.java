package com.xproject.master.app.entrypoint.client;

import com.xproject.master.domain.entity.client.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientController {
    ResponseEntity<Client> addClient(@RequestBody Client client);

    ResponseEntity<Client> getClientById(@PathVariable Long id);

    ResponseEntity<HttpStatus> putClient(@RequestBody Client client);

    ResponseEntity<HttpStatus> patchClient(@RequestBody Client client);
}
