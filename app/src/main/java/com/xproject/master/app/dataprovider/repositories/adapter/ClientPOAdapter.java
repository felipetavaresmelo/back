package com.xproject.master.app.dataprovider.repositories.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.entity.client.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientPOAdapter {

    public static ClientPO ofClient (Client client) {
        ClientPO clientPO = new ClientPO();
        clientPO.setId(client.getId());
        clientPO.setName(client.getName());
        clientPO.setPhone(client.getPhone());
        return clientPO;
    }

    public static List<ClientPO> ofClientList (List<Client> clientList) {
        return clientList.stream()
                .map(ClientPOAdapter::ofClient)
                .collect(Collectors.toList());
    }
}