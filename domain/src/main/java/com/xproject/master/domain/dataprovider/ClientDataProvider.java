package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.client.Client;

import java.util.List;

public interface ClientDataProvider {
    List<Client> getClients();
}
