package com.xproject.master.domain.usecase.register.client;

import com.xproject.master.domain.entity.client.Client;

public interface RegisterClientUseCase {

    Client addClient(Client client);

    Client getClientById(Long id);

    void putClient(Client client);

    void patchClient(Client client);

    Boolean deleteClient(Client client);
}
