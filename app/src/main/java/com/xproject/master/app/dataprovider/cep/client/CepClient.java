package com.xproject.master.app.dataprovider.cep.client;

import com.xproject.master.app.dataprovider.cep.dto.CepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CepClient", url = "https://viacep.com.br/ws/")
public interface CepClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json", produces = "application/json")
    CepDto getAdreessByCep(@PathVariable(name = "cep") String cep);
}
