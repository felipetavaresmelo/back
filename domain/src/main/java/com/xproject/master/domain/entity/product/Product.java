package com.xproject.master.domain.entity.product;

import com.xproject.master.domain.entity.client.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String productId;
    private String name;
    private String description;

    public Boolean isEqual(Product product) {
        return this.productId.equals(product.getProductId());
    }

}
