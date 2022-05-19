package com.xproject.master.domain.usecase.client.impl;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.usecase.client.FindClientListUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class FindClientListUseCaseImpl implements FindClientListUseCase {

    @Inject
    private ClientDataProvider clientDataProvider;

    @Override
    public List<Client> execute(List<Long> idList) {
        return clientDataProvider.findClientListByIdList(idList);
    }
}
