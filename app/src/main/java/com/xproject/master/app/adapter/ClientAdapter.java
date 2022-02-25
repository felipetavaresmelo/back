package com.xproject.master.app.adapter;

import com.xproject.master.app.dataprovider.repository.persistent.ClientPO;
import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;
import org.modelmapper.ModelMapper;

public class ClientAdapter {

    public static ClientPO convertToPO (Client client) {
        return new ModelMapper().map(client, ClientPO.class);
    }

    public static Client convert (ClientPO clientPO) {
        return new ModelMapper().map(clientPO, Client.class);
    }

    public static ClientDTO convertToDTO (Client client) {
        return new ModelMapper().map(client, ClientDTO.class);
    }

    public static Client convert (ClientDTO clientDTO) {
        return new ModelMapper().map(clientDTO, Client.class);
    }

}
