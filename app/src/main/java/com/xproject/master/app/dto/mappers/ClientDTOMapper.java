package com.xproject.master.app.dto.mappers;

import com.xproject.master.app.dto.ClientDTO;
import com.xproject.master.domain.entity.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientDTOMapper {

    ClientDTOMapper INSTANCE = Mappers.getMapper(ClientDTOMapper.class);

    ClientDTO ofClient(Client client);

    List<ClientDTO> map (List<Client> clientList);
}
