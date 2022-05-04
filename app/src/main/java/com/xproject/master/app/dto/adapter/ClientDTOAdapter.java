package com.xproject.master.app.dto.adapter;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDTOAdapter {

    public static ClientDTO ofClient (Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setPhone(client.getPhone());
        return clientDTO;
    }

    public static List<ClientDTO> ofClientList (List<Client> clientList) {
        return clientList.stream()
                .map(ClientDTOAdapter::ofClient)
                .collect(Collectors.toList());
    }
}