package com.xproject.master.domain.entity.adreess;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adreess {
      private String cep;
      private String street;
      private String district;
      private String city;
      private String state;
      private String country;
}
