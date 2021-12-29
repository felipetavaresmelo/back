package com.xproject.master.domain.entity.client.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PhoneTypeEnum {
    COMMERCIAL("COMMERCIAL"),
    PERSONAL("PERSONAL");

    private final String value;
}
