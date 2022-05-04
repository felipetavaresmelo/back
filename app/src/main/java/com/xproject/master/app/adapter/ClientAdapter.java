package com.xproject.master.app.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.entity.client.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientAdapter {
    public static Client ofClientPO (ClientPO clientPO) {
        Client client = new Client();
        client.setId(clientPO.getId());
        client.setName(clientPO.getName());
        client.setPhone(clientPO.getPhone());
        return client;
    }

    public static List<Client> ofClientPOList (List<ClientPO> clientPOList) {
        return clientPOList.stream()
                .map(ClientAdapter::ofClientPO)
                .collect(Collectors.toList());
    }
}
