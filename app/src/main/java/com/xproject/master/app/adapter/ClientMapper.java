package com.xproject.master.app.adapter;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClient (ClientPO clientPO);

    Client toClient (ClientDTO clientDTO);

    List<Client> map (List<ClientPO> clientPOList);
}
