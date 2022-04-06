package com.xproject.master.app.dataprovider.repositories.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClientPOAdapter {

    public static ClientPO convert (ClientDTO clientDTO) {
        return new ModelMapper().map(clientDTO, ClientPO.class);
    }

    public static ClientPO convert (Client client) {
        return new ModelMapper().map(client, ClientPO.class);
    }

    public static List<Client> convertToClient (List<ClientPO> clientPOList) {
        return clientPOList.stream()
                .map(clientPO -> new ModelMapper().map(clientPO, Client.class))
                .collect(Collectors.toList());
    }
}
