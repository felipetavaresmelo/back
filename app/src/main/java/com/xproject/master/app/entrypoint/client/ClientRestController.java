package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.adapter.ClientDTOMapper;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.GetClientByIdUseCase;
import com.xproject.master.domain.usecase.client.GetClientsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "client")
public class ClientRestController implements ClientController {

    @Autowired
    private GetClientsUseCase getClients;
    @Autowired
    private GetClientByIdUseCase getClientById;


    @Override
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> getClients() {
        List<Client> clientList = getClients.execute();
        List<ClientDTO> clientDTOList = ClientDTOMapper.INSTANCE.map(clientList);
        return ResponseEntity.ok().body(clientDTOList);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> getClientById (@PathVariable Long id) {
        Client client = getClientById.execute(id);
        ClientDTO clientDTO = ClientDTOMapper.INSTANCE.ofClient(client);
        return ResponseEntity.ok().body(clientDTO);
    }
}
