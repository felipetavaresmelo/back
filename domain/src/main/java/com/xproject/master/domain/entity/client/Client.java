package com.xproject.master.domain.entity.client;

import com.xproject.master.domain.entity.adreess.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Client {

    private Long id;
    private String name;
    private String phone;
    private Address address;
}
