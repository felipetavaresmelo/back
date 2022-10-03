package com.xproject.master.domain.usecase.adreess;

import com.xproject.master.domain.entity.adreess.Address;

public interface ReadAddressByCepUseCase {

    Address execute(String Cep);
}
