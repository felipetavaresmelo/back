package com.xproject.master.domain.entity.client;

import com.xproject.master.domain.dataprovider.CepDataProvider;
import com.xproject.master.domain.entity.adreess.Adreess;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private Long id;
    private String name;
    private String phone;
    private Adreess adreess;

    @Inject
    private CepDataProvider cepDataProvider;

    public Adreess setAdreess (Adreess adreess){
        if (Objects.isNull(adreess)){
            return new Adreess();
        }
        if (Objects.isNull(adreess.getCep())) {
            // TODO: Fazer busca de cep atraves de outros campos do endereço
            return adreess;
        }

        return cepDataProvider.getAdreessByCep(adreess.getCep());
    }
}
