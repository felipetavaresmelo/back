package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.FindClientByIdUseCase;
import com.xproject.master.domain.usecase.client.DeleteClientByIdUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.NoSuchElementException;
import java.util.Objects;

@Named
public class DeleteClientByIdUseCaseImpl implements DeleteClientByIdUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;
    @Inject
    private FindClientByIdUseCase findClientByIdUseCase;


    @Override
    public void execute(Long id) {
        final Client client = findClientByIdUseCase.execute(id);
        if(Objects.nonNull(client) && Objects.nonNull(client.getId())) {
            clientDataProvider.removeClientById(id);
        } else {
            throw new NoSuchElementException("Find client by id not found");
        }
    }
}
