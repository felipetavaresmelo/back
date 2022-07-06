package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.CreateClientUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;

@Named
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public Client execute(Client client) {
        if(Objects.nonNull(client) && Objects.nonNull(client.getId())){
            throw new IllegalArgumentException("Id should not filled.");
        }
        return clientDataProvider.saveClient(client);

    }
}
