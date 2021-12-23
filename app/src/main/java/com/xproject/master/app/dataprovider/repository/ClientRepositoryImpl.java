package com.xproject.master.app.dataprovider.repository;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

public class ClientRepositoryImpl implements ClientDataProvider {
    @Override
    public Client getClientById(String id) {
        return Client.builder()
                .clientId(id)
                .name("nome do cliente")
                .build();
    }
}
