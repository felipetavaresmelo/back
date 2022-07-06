package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.FindClientByIdUseCase;
import com.xproject.master.domain.usecase.client.UpdateClientUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.NoSuchElementException;
import java.util.Objects;

@Named
public class UpdateClientUseCaseImpl implements UpdateClientUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;
    @Inject
    private FindClientByIdUseCase findClientByIdUseCase;


    @Override
    public Client execute(Long id, Client client) {
        final Client clientObj = findClientByIdUseCase.execute(id);
        if(Objects.nonNull(clientObj) && Objects.nonNull(clientObj.getId())) {
            return clientDataProvider.updateClient(id, client);
        } else {
            throw new NoSuchElementException("Find client by id not found");
        }
    }
}
