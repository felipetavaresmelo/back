package com.xproject.master.app.dataprovider.repositories.mappers;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.domain.entity.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientPOMapper {

    ClientPOMapper INSTANCE = Mappers.getMapper(ClientPOMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "phone", target = "phone")
    ClientPO toClientPO (Client client);
}
