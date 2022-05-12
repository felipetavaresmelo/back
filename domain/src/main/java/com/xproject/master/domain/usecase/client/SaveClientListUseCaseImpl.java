package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SaveClientListUseCaseImpl implements SaveClientListUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public List<Client> execute(List<Client> clientList) {
        return clientDataProvider.saveClientList(clientList);
    }
}
