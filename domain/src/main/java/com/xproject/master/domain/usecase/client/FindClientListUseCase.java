package com.xproject.master.domain.usecase.client;

import com.xproject.master.domain.entity.client.Client;

import java.util.List;

public interface FindClientListUseCase {
    List<Client> execute(List<Long> idList);
}
