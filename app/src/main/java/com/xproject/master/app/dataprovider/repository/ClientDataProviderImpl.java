package com.xproject.master.app.dataprovider.repository;

import com.xproject.master.app.dataprovider.repository.jpa.ClientJpaRepository;
import com.xproject.master.app.dataprovider.repository.jpa.po.ClientPo;
import com.xproject.master.app.mappers.ClientMapper;
import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientDataProviderImpl implements ClientDataProvider {

    @Autowired
    private ClientJpaRepository repository;

    @Override
    public Client findClientById(Long id) {
        final ClientPo clientPoById = repository.findById(id).orElse(new ClientPo());
        return ClientMapper.INSTANCE.clientPOtoClient(clientPoById);
    }

    @Override
    public List<Client> findClientListByIdList (List<Long> idList) {
        final List<ClientPo> clientPoListById = repository.findAllById(idList);
        return ClientMapper.INSTANCE.clientPOListToClientList(clientPoListById);
    }

    @Override
    public List<Client> findClientList() {
        final List<ClientPo> clientPoList = repository.findAll();
        if(clientPoList.isEmpty()){
            return new ArrayList<>();
        }
        return ClientMapper.INSTANCE.clientPOListToClientList(clientPoList);
    }

    @Override
    public Client saveClient (Client client) {
        final ClientPo clientPoListIn = ClientMapper.INSTANCE.clientToClientPo(client);
        final ClientPo clientPoListOut = repository.save(clientPoListIn);
        return ClientMapper.INSTANCE.clientPOtoClient(clientPoListOut);
    }

    @Override
    public List<Client> saveClientList (List<Client> clientList) {
        final List<ClientPo> clientPoListIn = ClientMapper.INSTANCE.clientListToClientPoList(clientList);
        final List<ClientPo> clientPoListOut = repository.saveAll(clientPoListIn);
        return ClientMapper.INSTANCE.clientPOListToClientList(clientPoListOut);
    }

    @Override
    public void removeClientById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void removeClientList(List<Client> clientList) {
        final List<ClientPo> clientPoList = ClientMapper.INSTANCE.clientListToClientPoList(clientList);
        repository.deleteAll(clientPoList);
    }
    @Override
    public Client updateClient(Long id, Client client){
        final ClientPo clientPoOut = repository.findById(id).orElse(new ClientPo());
        clientPoOut.setName(client.getName());
        clientPoOut.setPhone(client.getPhone());
        final ClientPo clientPoIn = repository.save(clientPoOut);
        return ClientMapper.INSTANCE.clientPOtoClient(clientPoIn);
    }
}
