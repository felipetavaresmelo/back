package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import lombok.AllArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@AllArgsConstructor
public class ClientRegisterUseCaseImpl implements ClientRegisterUseCase {

    @Inject
    private final ClientDataProvider clientDataProvider;

    @Override
    public Client getClientById(String id) {
        return (clientDataProvider.getClientById(id));
    }

    @Override
    public Client postClient(Client client) {
        return clientDataProvider.postClient(client) ? client : new Client();
    }

    @Override
    public void putClient(Client client) {
        clientDataProvider.putClient(client);
    }

    @Override
    public void patchClient(Client client) {
        clientDataProvider.patchClient(client);
    }

    @Override
    public Boolean deleteClient(Client client) {
        return clientDataProvider.deleteClient(client);
    }
}
