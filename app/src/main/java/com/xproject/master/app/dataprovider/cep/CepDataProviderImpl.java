package com.xproject.master.app.dataprovider.cep;

import com.xproject.master.app.dataprovider.cep.client.CepClient;
import com.xproject.master.domain.dataprovider.CepDataProvider;
import com.xproject.master.domain.entity.adreess.Adreess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CepDataProviderImpl implements CepDataProvider {

    private final CepClient cepClient;

    public Adreess getAdreessByCep (String cep){
        ResponseEntity<Adreess> adreess = cepClient.getAdreessByCep(cep);

        if(Objects.isNull(adreess)){
            return new Adreess();
        }

        return adreess.getBody();
    }

}
