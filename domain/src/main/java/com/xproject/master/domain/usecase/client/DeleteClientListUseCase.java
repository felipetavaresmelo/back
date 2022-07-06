package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.entity.client.Client;

import java.util.List;

public interface DeleteClientListUseCase {
    void execute(List<Client> client);
}
