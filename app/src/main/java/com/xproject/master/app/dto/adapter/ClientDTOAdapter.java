package com.xproject.master.app.dto.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDTOAdapter {

    public static ClientDTO convertClient (Client client) {
        return new ModelMapper().map(client, ClientDTO.class);
    }

    public static List<ClientDTO> convertClientList (List<Client> clientList) {
        return clientList.stream()
                .map(client -> new ModelMapper().map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }

    public static ClientDTO convertClientPO (ClientPO clientPO) {
        return new ModelMapper().map(clientPO, ClientDTO.class);
    }

    public static List<ClientDTO> convertClientPOList (List<ClientPO> clientPOList) {
        return clientPOList.stream()
                .map(clientPO -> new ModelMapper().map(clientPO, ClientDTO.class))
                .collect(Collectors.toList());
    }
}
