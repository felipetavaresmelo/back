package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.FindClientByIdUseCase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FindClientByIdUseCaseImpl implements FindClientByIdUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public Client execute(Long id) {
        return clientDataProvider.findClientById(id);
    }
}
