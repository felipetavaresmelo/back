package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GetClientByIdUseCaseImpl implements GetClientByIdUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public Client execute(Long id) {
        return clientDataProvider.getClientById(id);
    }
}
