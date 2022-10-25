package com.xproject.master.domain.entity.order;

import com.xproject.master.domain.entity.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItem {

    private Product product;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
}
