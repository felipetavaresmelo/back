package com.xproject.master.app.dataprovider.cep.client;

import com.xproject.master.domain.entity.adreess.Adreess;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cep", url = "${dataprovider.cep.url}")
public interface CepClient {

    @GetMapping(path = "/{cep}")
    ResponseEntity<Adreess> getAdreessByCep(@PathVariable(name = "cep") String cep);
}
