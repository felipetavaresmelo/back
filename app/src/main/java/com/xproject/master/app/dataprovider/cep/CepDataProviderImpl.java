package com.xproject.master.app.dataprovider.cep;

import com.xproject.master.app.dataprovider.cep.client.CepClient;
import com.xproject.master.app.dataprovider.cep.dto.CepDto;
import com.xproject.master.app.dataprovider.cep.utils.CEPUtils;
import com.xproject.master.domain.dataprovider.CepDataProvider;
import com.xproject.master.domain.entity.adreess.Address;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CepDataProviderImpl implements CepDataProvider {

    @Autowired
    private CepClient cepClient;

    @Override
    public Address getAddressByCep(String cepString){
        Address address = new Address();

        CEPUtils.validaCep(cepString);

        CepDto cepDtoResponse = cepClient.getAdreessByCep(cepString);

        if(Objects.isNull(cepDtoResponse)){
            return address;
        }
        address.setCep(cepDtoResponse.getCep());
        address.setStreet(cepDtoResponse.getLogradouro() + ", " + cepDtoResponse.getComplemento());
        address.setDistrict(cepDtoResponse.getBairro());
        address.setCity(cepDtoResponse.getLocalidade());
        address.setState(cepDtoResponse.getUf());
        address.setCountry("Brasil");

        return address;
    }
}
