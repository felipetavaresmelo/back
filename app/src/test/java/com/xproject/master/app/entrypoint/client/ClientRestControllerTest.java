package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.adapter.ClientDTOAdapter;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.GetClientsUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ClientRestControllerTest {

    private List<ClientDTO> clientDTOList;
    private List<Client> clientList;
    private ResponseEntity<List<ClientDTO>> responseEntityClientDTOList;

    @InjectMocks
    ClientRestController clientRestController;
    @Mock
    GetClientsUseCaseImpl getClients;

    @BeforeEach
    void setUp() {
        clientDTOList = new ArrayList<>();

        ClientDTO clientDTO1 = new ClientDTO();
        clientDTO1.setName("Maria");
        clientDTO1.setPhone("111111111");
        clientDTOList.add(clientDTO1);

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setName("Brown");
        clientDTO2.setPhone("222222222");
        clientDTOList.add(clientDTO2);

        clientList = new ArrayList<>();

        Client client1 = new Client();
        client1.setName("Maria");
        client1.setPhone("111111111");
        clientList.add(client1);

        Client client2 = new Client();
        client2.setName("Brown");
        client2.setPhone("222222222");
        clientList.add(client2);

        HttpHeaders header = new HttpHeaders();

        responseEntityClientDTOList = new ResponseEntity<>(
                clientDTOList,
                header,
                HttpStatus.OK
        );

        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Quando consultar todos os clientes deve retornar com sucesso")
    void getClients() {

        when(getClients.execute()).thenReturn(clientList);
        Mockito.mockStatic(ClientDTOAdapter.class)
                .when(() -> ClientDTOAdapter.ofClientList(any()))
                .thenReturn(clientDTOList);

        ResponseEntity<List<ClientDTO>> result = clientRestController.getClients();

        assertEquals(responseEntityClientDTOList, result);
        assertEquals(clientDTOList, result.getBody());
    }

    @Test
    void getClientById() {
    }
}