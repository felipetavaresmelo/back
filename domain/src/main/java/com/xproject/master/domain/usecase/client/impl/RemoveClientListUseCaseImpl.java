package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.RemoveClientListUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class RemoveClientListUseCaseImpl implements RemoveClientListUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;



    @Override
    public void execute(List<Client> clientList) {
        if(!clientList.isEmpty()) {
            final List<Long> idList = clientList.stream().map(Client::getId).collect(Collectors.toList());
            if (!idList.isEmpty()) {
                final List<Client> clientListByIdList = clientDataProvider.findClientListByIdList(idList);
                clientDataProvider.removeClientList(clientListByIdList);
            }
        }
    }
}
