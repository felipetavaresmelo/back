package com.xproject.master.domain.entity.client;

import lombok.*;

//@Data
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Client {

    private Long id;
    private String name;
    private String phone;
}
