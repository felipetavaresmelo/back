package com.xproject.master.app.dataprovider.cep;

import com.xproject.master.app.dataprovider.cep.feignclient.CepClient;
import com.xproject.master.domain.dataprovider.CepDataProvider;
import com.xproject.master.domain.entity.adreess.Adreess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CepDataProviderImpl implements CepDataProvider {

    @Autowired
    private CepClient cepClient;

    public Adreess getAdreessByCep (String cep){
        ResponseEntity<Adreess> adreess = cepClient.getAdreessByCep(cep);

        if(Objects.isNull(adreess)){
            return new Adreess();
        }

        return adreess.getBody();
    }

}
