package com.xproject.master.domain.entity.client;

import com.xproject.master.domain.entity.client.enumerations.PhoneTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private String clientId;
    private String name;
    private String phone;
    private PhoneTypeEnum phoneType;

    public Boolean isEqual(Client client) {
        return this.clientId.equals(client.getClientId());
    }

    public void update(Client client) {
        this.name = client.getName();
        this.phone = client.getPhone();
        this.phoneType = client.phoneType;
    }
}
