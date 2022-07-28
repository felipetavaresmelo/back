package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.FindClientByIdUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.NoSuchElementException;
import java.util.Objects;

@Named
public class FindClientByIdUseCaseImpl implements FindClientByIdUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public Client execute(Long id) {
        final Client clientFound = clientDataProvider.findClientById(id);
        if(Objects.nonNull(clientFound) && Objects.nonNull(clientFound.getId())) {
            return clientFound;
        } else {
            throw new NoSuchElementException("Client not found.");
        }
    }
}
