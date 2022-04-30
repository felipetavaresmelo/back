package com.xproject.master.app.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientDTO {

    private Long id;
    private String name;
    private String phone;
}
