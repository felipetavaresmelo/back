package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.CreateClientUseCase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public Client execute(Client client) {
        client.setId(null);
        return clientDataProvider.saveClient(client);
    }
}
