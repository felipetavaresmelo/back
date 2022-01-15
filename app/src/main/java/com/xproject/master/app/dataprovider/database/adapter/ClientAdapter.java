package com.xproject.master.app.dataprovider.database.adapter;

import com.xproject.master.app.dataprovider.database.repository.model.ClientModel;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.entity.client.enumerations.PhoneTypeEnum;

public class ClientAdapter {

    public static ClientModel convert (Client client) {
        return ClientModel.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .phone(client.getPhone())
                .phoneType(client.getPhoneType().getValue())
                .age(client.getAge())
                .build();
    }

    public static Client convert (ClientModel clientModel) {
        return Client.builder()
                .id(clientModel.getId())
                .name(clientModel.getName())
                .surname(clientModel.getSurname())
                .phone(clientModel.getPhone())
                .phoneType(PhoneTypeEnum.valueOf(clientModel.getPhoneType()))
                .age(clientModel.getAge())
                .build();
    }
}
