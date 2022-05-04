package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.adapter.ClientDTOAdapter;
import com.xproject.master.app.dto.adapter.ClientDTOMapper;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.GetClientByIdUseCase;
import com.xproject.master.domain.usecase.client.GetClientsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
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
        List<Client> clientList;
        List<ClientDTO> clientDTOList = null;
        try {
            clientList = getClients.execute();
            if (clientList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            clientDTOList = ClientDTOAdapter.ofClientList(clientList);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(clientDTOList);
        }
        return ResponseEntity.ok().body(clientDTOList);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> getClientById (@PathVariable Long id) {
        Client client;
        ClientDTO clientDTO = null;
        try {
            client = getClientById.execute(id);
            if(ObjectUtils.isEmpty(client)) {
                return ResponseEntity.notFound().build();
            }
            clientDTO = ClientDTOMapper.INSTANCE.ofClient(client);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(clientDTO);
        }

        return ResponseEntity.ok().body(clientDTO);

    }
}
