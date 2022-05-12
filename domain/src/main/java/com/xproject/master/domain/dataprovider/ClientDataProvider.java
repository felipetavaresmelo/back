package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.client.Client;

import java.util.List;

public interface ClientDataProvider {
    Client getClientById (Long id);

    List<Client> getClientList();

    Client saveClient (Client client);

    List<Client> saveClientList(List<Client> clientList);
}
