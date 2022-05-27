package com.xproject.master.app.mappers;

import com.xproject.master.app.dataprovider.jpa.po.ClientPo;
import com.xproject.master.app.dto.ClientDto;
import com.xproject.master.domain.entity.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto clientToClientDto (Client client);

    ClientPo clientToClientPo (Client client);

    List<ClientDto> clientListToClientDtoList (List<Client> clientList);

    List<ClientPo> clientListToClientPoList (List<Client> clientList);

    Client clientPOtoClient(ClientPo clientPO);

    List<Client> clientPOListToClientList(List<ClientPo> clientPoList);

    Client clientDtoToClient(ClientDto clientDTO);

    List<Client> clientDtoListToClientList(List<ClientDto> clientDtoList);

}
