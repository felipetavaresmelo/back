package com.xproject.master.domain.usecase.user;

import com.xproject.master.domain.entity.Client;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetClientUseCaseImpl {

    public Client execute (String id) {

        return (new Client(id, "nome do cliente"));
    }
}
