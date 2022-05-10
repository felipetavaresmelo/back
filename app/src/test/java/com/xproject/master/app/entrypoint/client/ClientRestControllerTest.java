package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.app.dto.adapter.ClientDTOAdapter;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.GetClientsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ClientRestControllerTest {

    private ClientDTO clientDTO;
    private Client client;
    private ResponseEntity<?> responseEntity;

    @Mock
    ClientRestController clientRestController;

    @Mock
    GetClientsUseCase getClientsUseCase;

    @BeforeEach
    void setUp() {
        clientDTO = new ClientDTO();
        clientDTO.setName("Maria Brown");
        clientDTO.setPhone("988888888");

        client = new Client();
        client.setName("Maria Brown");
        client.setPhone("988888888");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        responseEntity = new ResponseEntity<>(
                client,
                header,
                HttpStatus.OK
        );
    }

    @Test
    @DisplayName("Quando consultar todos os clientes deve retornar ")
    void getClients() {

        when(getClientsUseCase.execute()).thenReturn(Collections.singletonList(client));
        when(ClientDTOAdapter.ofClientList(any())).thenReturn(Collections.singletonList(clientDTO));
        when(ResponseEntity.ok().body(any())).thenReturn(responseEntity);


        ResponseEntity<List<ClientDTO>> result = clientRestController.getClients();

        assertEquals("", result);
        Mockito.verify(mockedList).clear();
    }

    @Test
    void getClientById() {
    }
}