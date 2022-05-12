package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.adapter.ClientMapper;
import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.adapter.ClientDTOMapper;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.GetClientByIdUseCase;
import com.xproject.master.domain.usecase.client.GetClientListUseCase;
import com.xproject.master.domain.usecase.client.SaveClientListUseCase;
import com.xproject.master.domain.usecase.client.SaveClientUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "client")
public class ClientRestController implements ClientController {

    @Autowired
    private GetClientListUseCase getClientList;
    @Autowired
    private GetClientByIdUseCase getClientById;
    @Autowired
    private SaveClientUseCase saveClientUseCase;
    @Autowired
    private SaveClientListUseCase saveClientListUseCase;

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> getClientList() {
        List<Client> clientList = getClientList.execute();
        List<ClientDTO> clientDTOList = ClientDTOMapper.INSTANCE.ofClientList(clientList);
        return ResponseEntity.ok().body(clientDTOList);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> getClientById (@PathVariable Long id) {
        if(Objects.nonNull(id)) {
            Client client = getClientById.execute(id);
            ClientDTO clientDTO = ClientDTOMapper.INSTANCE.ofClient(client);
            return ResponseEntity.ok().body(clientDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
        if(Objects.nonNull(clientDTO)) {
            Client client = ClientMapper.INSTANCE.ofClientDTO(clientDTO);
            Client clientResponse = saveClientUseCase.execute(client);
            ClientDTO clientDTOResponse = ClientDTOMapper.INSTANCE.ofClient(clientResponse);
            return ResponseEntity.ok().body(clientDTOResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> saveClientList(@RequestBody List<ClientDTO> clientDTOList) {
        if(Objects.nonNull(clientDTOList)) {
            List<Client> clientList = ClientMapper.INSTANCE.ofClientDTOList(clientDTOList);
            List<Client> clientListResponse = saveClientListUseCase.execute(clientList);
            List<ClientDTO> clientDTOListResponse = ClientDTOMapper.INSTANCE.ofClientList(clientListResponse);
            return ResponseEntity.ok().body(clientDTOListResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
