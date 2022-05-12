package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.adapter.ClientDTOMapperImpl;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.GetClientByIdUseCase;
import com.xproject.master.domain.usecase.client.GetClientsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class ClientRestControllerTest {
    private ClientDTO clientDTO;
    private List<ClientDTO> clientDTOList;
    private Client client;
    private List<Client> clientList;

    @InjectMocks
    ClientRestController clientRestController;
    @Mock
    GetClientsUseCase getClients;
    @Mock
    GetClientByIdUseCase getClientById;
    @Mock
    ClientDTOMapperImpl clientDTOMapper;


    @BeforeEach
    void setUp() {
        clientDTOList = new ArrayList<>();

        clientDTO = new ClientDTO();
        clientDTO.setName("Maria");
        clientDTO.setPhone("111111111");
        clientDTOList.add(clientDTO);

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setName("Brown");
        clientDTO2.setPhone("222222222");
        clientDTOList.add(clientDTO2);

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
    @DisplayName("Quando consultar todos os clientes deve retornar com sucesso")
    void getClients() {
        ResponseEntity<List<ClientDTO>> responseEntityClientDTOList = new ResponseEntity<>(
                clientDTOList,
                new HttpHeaders(),
                HttpStatus.OK
        );
        when(getClients.execute()).thenReturn(clientList);

        ResponseEntity<List<ClientDTO>> result = clientRestController.getClients();

        assertEquals(responseEntityClientDTOList, result);
        assertEquals(clientDTOList, result.getBody());
    }

    @Test
    @DisplayName("Quando consultar o cliente pelo ID deve retornar com sucesso")
    void getClientById() {

        HttpHeaders header = new HttpHeaders();
        ResponseEntity<ClientDTO> responseEntityClientDTO = new ResponseEntity<>(
                clientDTO,
                header,
                HttpStatus.OK
        );
        when(getClientById.execute(any())).thenReturn(client);

        ResponseEntity<ClientDTO> result = clientRestController.getClientById(any());

        assertEquals(responseEntityClientDTO, result);
        assertEquals(clientDTO, result.getBody());
    }
}