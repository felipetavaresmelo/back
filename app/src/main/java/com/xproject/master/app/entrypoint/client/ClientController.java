package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientController {
    ResponseEntity<List<ClientDTO>> getClients();
}
