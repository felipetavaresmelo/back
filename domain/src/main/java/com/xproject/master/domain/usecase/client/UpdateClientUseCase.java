package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.entity.client.Client;

public interface UpdateClientUseCase {
    Client execute(Long id, Client client);
}
