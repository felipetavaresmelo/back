package com.xproject.master.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private final String name;
    private final String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
