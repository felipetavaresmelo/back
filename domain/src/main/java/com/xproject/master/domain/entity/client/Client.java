package com.xproject.master.domain.entity.client;

import com.xproject.master.domain.entity.adreess.Address;
import com.xproject.master.domain.usecase.adreess.impl.ReadAddressByCepImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Client {

    private Long id;
    private String name;
    private String phone;
    private Address address;
}
