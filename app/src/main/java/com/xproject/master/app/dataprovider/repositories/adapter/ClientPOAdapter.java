package com.xproject.master.app.dataprovider.repositories.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.entity.client.Client;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClientPOAdapter {

    public static List<Client> convertToClient (List<ClientPO> clientPOList) {
        return clientPOList.stream()
                .map(clientPO -> new ModelMapper().map(clientPO, Client.class))
                .collect(Collectors.toList());
    }
}
