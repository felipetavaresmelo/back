package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetClientUseCaseImpl implements GetClientUseCase {

    private final ClientDataProvider clientDataProvider;

    @Override
    public Client execute(String id) {
        return (clientDataProvider.getClientById(id));
    }
}
