package com.xproject.master.domain.usecase.register.client;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetClientsUseCase {

    private ClientDataProvider clientDataProvider;

    public List<Client> getClients() {
        return clientDataProvider.getClients();
    }
}
