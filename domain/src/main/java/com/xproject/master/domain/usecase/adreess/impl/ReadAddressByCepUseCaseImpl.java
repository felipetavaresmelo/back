package com.xproject.master.domain.usecase.adreess.impl;

import com.xproject.master.domain.dataprovider.CepDataProvider;
import com.xproject.master.domain.entity.adreess.Address;
import com.xproject.master.domain.usecase.adreess.ReadAddressByCepUseCase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ReadAddressByCepUseCaseImpl implements ReadAddressByCepUseCase {

    @Inject
    private CepDataProvider cepDataProvider;

    @Override
    public Address execute(String cep) {
        return cepDataProvider.getAddressByCep(cep);
    }
}
