package com.xproject.master.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
      private String cep;
      private String street;
      private String district;
      private String city;
      private String state;
      private String country;
}
