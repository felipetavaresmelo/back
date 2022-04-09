package com.xproject.master.app.dataprovider;

import com.xproject.master.app.dataprovider.repositories.ClientJpaRepository;
import com.xproject.master.app.dataprovider.repositories.adapter.ClientPOAdapter;
import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public abstract class ClientDataService implements ClientDataProvider {

    @Inject
    private ClientJpaRepository clientData;

    @Override
    public List<Client> getClients() {
        List<ClientPO> clientPOList = clientData.findAll();
        if(clientPOList.isEmpty()){
            return new ArrayList<>();
        }

        return ClientPOAdapter.convertToClient(clientPOList);
    }
}
