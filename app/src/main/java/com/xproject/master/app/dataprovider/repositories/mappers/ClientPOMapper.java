package com.xproject.master.app.dataprovider.repositories.mappers;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.entity.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientPOMapper {

    ClientPOMapper INSTANCE = Mappers.getMapper(ClientPOMapper.class);

    ClientPO ofClient (Client client);
}
