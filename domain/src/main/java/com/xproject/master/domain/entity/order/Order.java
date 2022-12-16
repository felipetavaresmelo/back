package com.xproject.master.domain.entity.order;

import com.xproject.master.domain.entity.client.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Order {

    private Long id;
    private Client client;
    private List<OrderItem> orderItemList;
}
