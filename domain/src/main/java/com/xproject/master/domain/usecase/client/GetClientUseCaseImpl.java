package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.entity.client.Client;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetClientUseCaseImpl {

    public Client execute (String id) {

        return (Client.builder()
                .clientId(id)
                .name("nome do cliente")
                .build()
        );
    }
}
