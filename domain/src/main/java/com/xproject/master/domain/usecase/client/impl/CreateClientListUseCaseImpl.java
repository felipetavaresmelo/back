package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.CreateClientListUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CreateClientListUseCaseImpl implements CreateClientListUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public List<Client> execute(List<Client> clientList) {
        for(Client cli : clientList){
            cli.setId(null);
        }
        return clientDataProvider.saveClientList(clientList);
    }
}