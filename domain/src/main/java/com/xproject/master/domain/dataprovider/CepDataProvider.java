package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.adreess.Adreess;

public interface CepDataProvider {

    Adreess getAdreessByCep (String cep);
}
