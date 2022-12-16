package com.xproject.master.domain.usecase.order;

import com.xproject.master.domain.entity.order.Order;

public interface CreateOrderUseCase {
    Order execute(Order order);
}
