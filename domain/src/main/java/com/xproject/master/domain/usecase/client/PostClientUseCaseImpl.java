package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import lombok.AllArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@AllArgsConstructor
public class PostClientUseCaseImpl implements PostClientUseCase {

    @Inject
    private final ClientDataProvider clientDataProvider;

    @Override
    public Client postClient(Client client) {
        return clientDataProvider.postClient(client);
    }
}
