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

    @Override
    public Client findClientById(Long id) {
        final ClientPO clientPOById = clientData.findById(id).orElse(new ClientPO());
        return ClientMapper.INSTANCE.ofClientPO(clientPOById);
    }

    public List<Client> findClientListByIdList (List<Long> idList) {
        final List<ClientPO> clientPOListById = clientData.findAllById(idList);
        return ClientMapper.INSTANCE.ofClientPOList(clientPOListById);
    }

    @Override
    public List<Client> findClientList() {
        final List<ClientPO> clientPOList = clientData.findAll();
        if(clientPOList.isEmpty()){
            return new ArrayList<>();
        }
        return ClientMapper.INSTANCE.ofClientPOList(clientPOList);
    }

    @Override
    public Client saveClient (Client client) {
        final ClientPO clientPOListIn = ClientPOMapper.INSTANCE.ofClient(client);
        final ClientPO clientPOListOut = clientData.save(clientPOListIn);
        return ClientMapper.INSTANCE.ofClientPO(clientPOListOut);
    }

    @Override
    public List<Client> saveClientList (List<Client> clientList) {
        final List<ClientPO> clientPOListIn = ClientPOMapper.INSTANCE.ofClientList(clientList);
        final List<ClientPO> clientPOListOut = clientData.saveAll(clientPOListIn);
        return ClientMapper.INSTANCE.ofClientPOList(clientPOListOut);
    }

    @Override
    public void removeClientById(Long id) {
        clientData.deleteById(id);
    }

    @Override
    public void removeClientList(List<Client> clientList) {
        final List<ClientPO> clientPOList = ClientPOMapper.INSTANCE.ofClientList(clientList);
        clientData.deleteAll(clientPOList);
    }
}
