package com.xproject.master.domain.entity.adreess;

import com.xproject.master.domain.usecase.adreess.ReadAddressByCep;
import lombok.Data;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Objects;

@Data
@Named
public class Address {
      private String cep;
      private String street;
      private String district;
      private String city;
      private String state;
      private String country;

      public static final String CEP_PtBr = "CEP";
      private static final String STREET_PtBr = "Rua";
      private static final String DISTRICT_PtBr = "Bairro";
      private static final String CITY_PtBr = "Cidade";
      private static final String STATE_PtBr = "Estado";
      private static final String COUNTRY_PtBr = "País";

      private ReadAddressByCep readAddressByCep;

      public Address () {}

      public Address (ReadAddressByCep readAddressByCep){
            this.readAddressByCep = readAddressByCep;
      }

      public void setCep(String cep) {
            if (cep.isEmpty()){
                  this.cep = "";
                  return;
            }

            this.cep = cep;

            if(readAddressByCep != null) {
                  ArrayList<String> addressNotFound = checkAddressNotFound();
                  if (addressNotFound.size() > 0) {
                        Address addressFound = this.readAddressByCep.execute(cep);

                        this.street = addressNotFound.contains(Address.STREET_PtBr) ? addressFound.getStreet() : this.street;
                        this.district = addressNotFound.contains(Address.DISTRICT_PtBr) ? addressFound.getDistrict() : this.district;
                        this.city = addressNotFound.contains(Address.CITY_PtBr) ? addressFound.getCity() : this.city;
                        this.state = addressNotFound.contains(Address.STATE_PtBr) ? addressFound.getState() : this.state;
                        this.country = addressNotFound.contains(Address.COUNTRY_PtBr) ? addressFound.getCountry() : this.country;
                  }
            }
      }

      public ArrayList<String> checkAddressNotFound (){
            ArrayList<String> resultList = new ArrayList<>();

            if(Objects.isNull(this.cep)){
                  resultList.add(CEP_PtBr);
            }

            if(Objects.isNull(this.street)){
                  resultList.add(STREET_PtBr);
            }

            if(Objects.isNull(this.district)){
                  resultList.add(DISTRICT_PtBr);
            }

            if(Objects.isNull(this.city)){
                  resultList.add(CITY_PtBr);
            }

            if(Objects.isNull(this.state)){
                  resultList.add(STATE_PtBr);
            }

            if(Objects.isNull(this.country)){
                  resultList.add(COUNTRY_PtBr);
            }

            return resultList;
      }
}
