package com.xproject.master.app.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;
import org.modelmapper.ModelMapper;

public class ClientAdapter {

    public static Client convertClientPO(ClientPO clientPO) {
        return new ModelMapper().map(clientPO, Client.class);
    }

    public static Client convertClientDTO (ClientDTO clientDTO) {
        return new ModelMapper().map(clientDTO, Client.class);
    }

}
