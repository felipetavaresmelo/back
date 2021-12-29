package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.client.Client;

public interface ClientDataProvider {
    Client getClientById(String id);

    Boolean postClient(Client client);

    void putClient(Client client);

    void patchClient(Client client);

    Boolean deleteClient(Client client);
}
