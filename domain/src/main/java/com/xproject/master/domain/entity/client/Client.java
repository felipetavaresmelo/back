package com.xproject.master.domain.entity.client;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public final class Client {

    private Long id;
    private String name;
    private String phone;
}
