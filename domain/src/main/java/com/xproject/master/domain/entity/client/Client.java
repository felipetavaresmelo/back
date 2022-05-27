package com.xproject.master.domain.entity.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private Long id;
    private String name;
    private String phone;
}
