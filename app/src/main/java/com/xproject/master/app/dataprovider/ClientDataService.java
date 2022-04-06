package com.xproject.master.app.dataprovider;

import com.xproject.master.app.dataprovider.repositories.ClientRepository;
import com.xproject.master.app.dataprovider.repositories.adapter.ClientPOAdapter;
import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

//@Service
@Named
public abstract class ClientDataService implements ClientDataProvider {

    @Inject
    private ClientRepository clientData;

//    @Override
//    public Client addClient(Client client) {
//        return ClientAdapter.convertClientPO(clientData.save(ClientPOAdapter.convert(client)));
//    }

    @Override
    public List<Client> getClients() {
        List<ClientPO> clientPOList = clientData.findAll();
        if(clientPOList.isEmpty()){
            return new ArrayList<>();
        }

        return ClientPOAdapter.convertToClient(clientPOList);
    }
//
//    @Override
//    public Client getClientById(Long id) {
//        Optional<ClientPO> clientPO = clientData.findById(id);
//        if(clientPO.isEmpty()) {
//            return Client.builder().build();
//        }
//        return ClientAdapter.convertClientPO(clientPO.get());
//    }
//
//    @Override
//    public void putClient(Client client) {
//
//    }
//
//    @Override
//    public void patchClient(Client client) {
//
//    }
//
//    @Override
//    public Boolean deleteClient(Client client) {
//        return false;
//    }
}
