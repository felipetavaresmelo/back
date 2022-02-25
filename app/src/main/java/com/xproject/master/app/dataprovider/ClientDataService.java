package com.xproject.master.app.dataprovider;

import com.xproject.master.app.adapter.ClientAdapter;
import com.xproject.master.app.dataprovider.repository.ClientRepository;
import com.xproject.master.app.dataprovider.repository.persistent.ClientPO;
import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public abstract class ClientDataService implements ClientDataProvider {

    @Inject
    private ClientRepository clientData;

//    @Inject
    public ClientDataService(ClientRepository clientData) {
        this.clientData = clientData;
    }

    @Override
    public Client addClient(Client client) {
        return ClientAdapter.convert(clientData.save(ClientAdapter.convertToPO(client)));
    }

    @Override
    public Client getClientById(Long id) {
        Optional<ClientPO> clientModel = clientData.findById(id);
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
