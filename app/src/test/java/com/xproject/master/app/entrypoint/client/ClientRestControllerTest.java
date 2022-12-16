package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDto;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.FindClientAllUseCase;
import com.xproject.master.domain.usecase.client.FindClientByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class ClientRestControllerTest {
    private ClientDto clientDTO;
    private List<ClientDto> clientDtoList;
    private Client client;
    private List<Client> clientList;

    @InjectMocks
    ClientRestController clientRestController;
    @Mock
    FindClientAllUseCase getClientList;
    @Mock
    FindClientByIdUseCase getClientById;

    @BeforeEach
    void setUp() {
        clientDtoList = new ArrayList<>();

        clientDTO = new ClientDto();
        clientDTO.setName("Maria");
        clientDTO.setPhone("111111111");
        clientDtoList.add(clientDTO);

        ClientDto clientDto2 = new ClientDto();
        clientDto2.setName("Brown");
        clientDto2.setPhone("222222222");
        clientDtoList.add(clientDto2);

        clientList = new ArrayList<>();

        client = new Client();
        client.setName("Maria");
        client.setPhone("111111111");
        clientList.add(client);

        Client client2 = new Client();
        client2.setName("Brown");
        client2.setPhone("222222222");
        clientList.add(client2);

        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("When querying all clients need to return successfully.")
    void getClients() {
        ResponseEntity<List<ClientDto>> responseEntityClientDTOList = new ResponseEntity<>(
                clientDtoList,
                new HttpHeaders(),
                HttpStatus.OK
        );
        when(getClientList.execute()).thenReturn(clientList);

        ResponseEntity<List<ClientDto>> result = clientRestController.findClientAll();

        assertEquals(responseEntityClientDTOList, result);
        assertEquals(clientDtoList, result.getBody());
    }

    @Test
    @DisplayName("When querying the client by ID, it needs to return successfully.")
    void getClientById() {

        HttpHeaders header = new HttpHeaders();
        ResponseEntity<ClientDto> responseEntityClientDTO = new ResponseEntity<>(
                clientDTO,
                header,
                HttpStatus.OK
        );
        when(getClientById.execute(any())).thenReturn(client);

        ResponseEntity<ClientDto> result = clientRestController.findClientById(1L);

        assertEquals(responseEntityClientDTO, result);
        assertEquals(clientDTO, result.getBody());
    }
}