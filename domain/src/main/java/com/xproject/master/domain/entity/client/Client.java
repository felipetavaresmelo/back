package com.xproject.master.domain.entity.client;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public final class Client {

    private Long id;
    private String name;
    private String phone;
}
