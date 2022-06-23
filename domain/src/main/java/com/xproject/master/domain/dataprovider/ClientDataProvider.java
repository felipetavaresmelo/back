package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.client.Client;

import java.util.List;

public interface ClientDataProvider {
    Client findClientById(Long id);

    List<Client> findClientList();

    List<Client> findClientListByIdList (List<Long> idList);

    Client saveClient (Client client);

    List<Client> saveClientList(List<Client> clientList);

    void removeClientById(Long id);

    void removeClientList(List<Client> clientList);

    Client updateClient(Long id, Client client);
}
