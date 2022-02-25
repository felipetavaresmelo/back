package com.xproject.master.app.dto;

import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.entity.client.enumerations.PhoneTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private int age;
    private PhoneTypeEnum phoneType;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.surname = client.getSurname();
        this.phone = client.getPhone();
        this.age = client.getAge();
        this.phoneType = client.getPhoneType();
    }
}
