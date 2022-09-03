package com.xproject.master.domain.usecase.adreess.impl;

import com.xproject.master.domain.dataprovider.CepDataProvider;
import com.xproject.master.domain.entity.adreess.Address;
import com.xproject.master.domain.usecase.adreess.ReadAddressByCep;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ReadAddressByCepImpl implements ReadAddressByCep {

    @Inject
    private CepDataProvider cepDataProvider;

    @Override
    public Address execute(String cep) {
        return cepDataProvider.getAddressByCep(cep);
    }
}
