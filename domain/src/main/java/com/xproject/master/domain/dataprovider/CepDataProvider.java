package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.adreess.Address;

public interface CepDataProvider {

    Address getAddressByCep(String cep);
}
