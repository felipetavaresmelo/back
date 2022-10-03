package com.xproject.master.app.dataprovider.repository.jpa.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class AddressPo {

      private static final long serialVersionUID = 3L;

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String cep;
      private String street;
      private String district;
      private String city;
      private String state;
      private String country;

      @OneToOne(mappedBy = "address")
      private ClientPo client;
}
