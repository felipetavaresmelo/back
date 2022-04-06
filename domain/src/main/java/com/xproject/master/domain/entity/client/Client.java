package com.xproject.master.domain.entity.client;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Long id;
    private String name;
    private String phone;
}
