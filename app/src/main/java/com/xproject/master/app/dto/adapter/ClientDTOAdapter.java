package com.xproject.master.app.dto.adapter;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDTOAdapter {

    public static List<ClientDTO> convertClientList (List<Client> clientList) {
        return clientList.stream()
                .map(client -> new ModelMapper().map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }
}
