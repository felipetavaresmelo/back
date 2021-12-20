package com.xproject.master.domain.entity.product.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductCategoryEnum {
    TECNOLOGY ("TECNOLOGY"),
    BOOKS ("BOOKS");

    private final String value;
}
