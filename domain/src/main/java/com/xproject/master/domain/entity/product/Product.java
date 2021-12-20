package com.xproject.master.domain.entity.product;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String productId;
    private String name;
    private String description;
}
