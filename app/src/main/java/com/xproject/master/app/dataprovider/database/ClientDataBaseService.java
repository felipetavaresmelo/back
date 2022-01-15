package com.xproject.master.app.dataprovider.database;

import com.xproject.master.app.dataprovider.database.adapter.ClientAdapter;
import com.xproject.master.app.dataprovider.database.repository.ClientRepository;
import com.xproject.master.app.dataprovider.database.repository.model.ClientModel;
import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public abstract class ClientDataBaseService implements ClientDataProvider {

    private ClientRepository clientRepository;

    @Inject
    public ClientDataBaseService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(Client client) {
        return ClientAdapter.convert(clientRepository.save(ClientAdapter.convert(client)));
    }

    @Override
    public Client getClientById(Long id) {
        Optional<ClientModel> clientModel = clientRepository.findById(id);
        if(clientModel.isPresent()){
            return ClientAdapter.convert(clientModel.get());
        }
        return Client.builder().build();
    }

    @Override
    public void putClient(Client client) {

    }

    @Override
    public void patchClient(Client client) {

    }

    @Override
    public Boolean deleteClient(Client client) {
        return false;
    }
}
