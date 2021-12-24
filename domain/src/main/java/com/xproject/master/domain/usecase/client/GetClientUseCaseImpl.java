package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import lombok.AllArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@AllArgsConstructor
public class GetClientUseCaseImpl implements GetClientUseCase {

    @Inject
    private final ClientDataProvider clientDataProvider;

    @Override
    public Client getClientById(String id) {
        return (clientDataProvider.getClientById(id));
    }
}
