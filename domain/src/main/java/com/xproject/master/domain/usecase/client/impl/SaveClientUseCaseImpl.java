package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.SaveClientUseCase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SaveClientUseCaseImpl implements SaveClientUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public Client execute(Client client) {
        return clientDataProvider.saveClient(client);
    }
}