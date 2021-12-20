package com.xproject.master.domain.entity;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Client {

    @NonNull
    private String id;
    @NonNull
    private String name;
    private String phone;
}
