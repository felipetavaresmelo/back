package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.mappers.ClientDTOMapper;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.GetClientsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "client")
public class ClientRestController implements ClientController {

    @Autowired
    private GetClientsUseCase useCase;

    @Override
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> getClients() {
        List<Client> clientList;
        List<ClientDTO> clientDTOList = null;
        try {
            clientList = useCase.getClients();
            clientDTOList = ClientDTOMapper.INSTANCE.map(clientList);
            if (clientDTOList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(clientDTOList);
        }
        return ResponseEntity.ok().body(clientDTOList);
    }
}
