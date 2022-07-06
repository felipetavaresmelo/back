package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.CreateClientListUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

@Named
public class CreateClientListUseCaseImpl implements CreateClientListUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public List<Client> execute(List<Client> clientList) {
        for(Client cli : clientList){
            if(Objects.nonNull(cli) && Objects.nonNull(cli.getId())){
                throw new IllegalArgumentException("Id should not filled.");
            }
        }
        return clientDataProvider.saveClientList(clientList);
    }
}
