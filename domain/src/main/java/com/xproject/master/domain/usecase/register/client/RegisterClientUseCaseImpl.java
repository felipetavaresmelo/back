package com.xproject.master.domain.usecase.register.client;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegisterClientUseCaseImpl implements RegisterClientUseCase {

    @Inject
    private final ClientDataProvider clientDataProvider;

//    @Inject
    public RegisterClientUseCaseImpl(@Named("clientDataProvider") ClientDataProvider clientDataProvider) {
        this.clientDataProvider = clientDataProvider;
    }

    @Override
    public Client addClient(Client client) {
        return clientDataProvider.addClient(client);
    }

    @Override
    public Client getClientById(Long id) {
        return (clientDataProvider.getClientById(id));
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
