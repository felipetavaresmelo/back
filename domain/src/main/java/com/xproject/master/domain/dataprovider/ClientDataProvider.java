package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.client.Client;

import java.util.List;

public interface ClientDataProvider {

//    Client addClient(Client client);

    List<Client> getClients();

//    Client getClientById(Long id);
//
//    void putClient(Client client);
//
//    void patchClient(Client client);
//
//    Boolean deleteClient(Client client);
}
