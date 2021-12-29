package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.entity.client.Client;

public interface ClientRegisterUseCase {

    Client getClientById(String id);

    Client postClient(Client client);

    void putClient(Client client);

    void patchClient(Client client);

    Boolean deleteClient(Client client);
}
