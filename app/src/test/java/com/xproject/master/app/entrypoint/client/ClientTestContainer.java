package com.xproject.master.app.entrypoint.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xproject.master.app.dto.AddressDto;
import com.xproject.master.app.dto.ClientDto;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.adreess.ReadAddressByCepUseCase;
import com.xproject.master.domain.usecase.client.CreateClientUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@Transactional
@AutoConfigureMockMvc
public class ClientTestContainer {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private List<ClientDto> clientDtoList;
    private Client client;
    private List<Client> clientList;
    private Long existingId;
    private Long existingId2;
    private Long nonExistingId;
    private ClientDto clientDto1;
    private ClientDto clientDto2;

    @BeforeEach
    void setUp() {
        existingId = 1L;
        existingId2 = 2L;
        nonExistingId = 1000L;
        clientDtoList = new ArrayList<>();
        clientDto1 = new ClientDto();

        clientDto1.setName("Antonio Silva");
        clientDto1.setPhone("988888888");
        AddressDto address1 = new AddressDto();
        address1.setCep("51020090");
        clientDto1.setAddress(address1);

        clientDto2 = new ClientDto();
        clientDto2.setId(existingId);
        clientDto2.setName("Brown");
        clientDto2.setPhone("222222222");
        clientDto2.setAddress(address1);
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
    @DisplayName("Create should return Status 201(Created) and Client")
    void saveClientShouldReturnStatusCreatedWhenValidData() throws Exception{

        String jsonBody = objectMapper.writeValueAsString(clientDto1);
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.post("/client/")
                       .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(existingId2));
    }
    @Test
    @DisplayName("Find should return Client And Status 200(Ok) when id exists")
    void findByIdClientShouldReturnStatusOkWhenValidData() throws Exception{
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.get("/client/{$id}", existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(existingId));
    }
    @Test
    @DisplayName("Find should return NotFound 404 when id does not exists")
    void findByIdClientShouldReturnNotFoundWhenIdDoesNotExists() throws Exception{
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.get("/client/{$id}", nonExistingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Find All should return List And Status 200(Ok)")
    void findAllClientShouldReturnStatusOkWhenValidData() throws Exception{

        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.get("/client/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
    }
    @Test
    @DisplayName("Delete should return Status 200 (Ok) When id exists")
    void deleteClientShouldReturnStatusOkWhenIdExists() throws Exception{
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.delete("/client/{$id}", existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());

    }
    @Test
    @DisplayName("Delete should return NotFound when Id does not exists")
    void deleteClientShouldReturnNotfoundWhenIdDoesNotExists() throws Exception{
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.delete("/client/{$id}", nonExistingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("Update should return Status 200(Ok) and Client")
    void updateClientShouldReturnStatusOkWhenValidData() throws Exception{

        String jsonBody = objectMapper.writeValueAsString(clientDto2);
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.put("/client/{$id}", existingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(existingId))
                .andExpect(jsonPath("$.name").value(clientDto2.getName()))
                .andExpect(jsonPath("$.phone").value(clientDto2.getPhone()));
    }
    @Test
    @DisplayName("Update should NotFound 404 when Id does not exists")
    void updateClientShouldReturnNotFoundWhenIdDoesNotExists() throws Exception{

        String jsonBody = objectMapper.writeValueAsString(clientDto2);
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.put("/client/{$id}", nonExistingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }


}
