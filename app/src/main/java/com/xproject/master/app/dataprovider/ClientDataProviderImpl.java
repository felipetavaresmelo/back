package com.xproject.master.app.dataprovider;

import com.xproject.master.app.adapter.ClientMapper;
import com.xproject.master.app.dataprovider.repositories.ClientJpaRepository;
import com.xproject.master.app.dataprovider.repositories.adapter.ClientPOMapper;
import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientDataProviderImpl implements ClientDataProvider {

    @Autowired
    private ClientJpaRepository clientData;

    //CLIENTPO

    public ClientPO getClientPOById (Long id) {
        return clientData.getById(id);
    }

    public ClientPO saveClientPO (ClientPO clientPO) {
        return clientData.save(clientPO);
    }

    public List<ClientPO> saveClientPOList (List<ClientPO> clientPOList) {
        return clientData.saveAll(clientPOList);
    }

    public void deleteClientPO (ClientPO clientPO) {
        clientData.delete(clientPO);
    }

    public void deleteClientPOList (List<ClientPO> clientPOList) {
        clientData.deleteAll(clientPOList);
    }

    // CLIENT

    public Client getClientById (Long id) {
        return ClientMapper.INSTANCE.ofClientPO(getClientPOById(id));
    }

    public Client saveClient(Client client) {
        return ClientMapper.INSTANCE.ofClientPO(saveClientPO(ClientPOMapper.INSTANCE.ofClient(client)));
    }

    public List<Client> saveClientList (List<Client> clientList) {
        return ClientMapper.INSTANCE.map(saveClientPOList(ClientPOMapper.INSTANCE.map(clientList)));
    }

    @Override
    public List<Client> getClients() {
        List<ClientPO> clientPOList = clientData.findAll();
        if(clientPOList.isEmpty()){
            return new ArrayList<>();
        }
        return ClientMapper.INSTANCE.map(clientPOList);
    }
}
