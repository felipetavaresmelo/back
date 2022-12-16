package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.entity.order.Order;

import java.util.List;

public interface OrderDataProvider {

    Order saveOrder (Order order);

    Order findOrderById (Long id);

    List<Order> getOrderListByClient(Client client);
}
