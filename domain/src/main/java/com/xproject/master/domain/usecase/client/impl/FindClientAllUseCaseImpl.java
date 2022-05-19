package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.FindClientAllUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class FindClientAllUseCaseImpl implements FindClientAllUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public List<Client> execute() {
        return clientDataProvider.findClientList();
    }
}
