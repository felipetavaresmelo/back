package com.xproject.master.app.dataprovider.repositories.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.entity.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientPOMapper {

    ClientPOMapper INSTANCE = Mappers.getMapper(ClientPOMapper.class);

    ClientPO ofClient(Client client);

    List<ClientPO> map (List<Client> clientList);
}