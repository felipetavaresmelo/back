package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.entity.client.Client;

public interface SaveClientUseCase {
    Client execute(Client client);
}
