package com.xproject.master.domain.usecase.order.impl;

import com.xproject.master.domain.dataprovider.OrderDataProvider;
import com.xproject.master.domain.entity.order.Order;
import com.xproject.master.domain.usecase.order.CreateOrderUseCase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;

@Named
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    @Inject
    private OrderDataProvider orderDataProvider;

    @Override
    public Order execute(Order order) {

        if(Objects.nonNull(order) && Objects.nonNull(order.getId())){
            throw new IllegalArgumentException("Id should not filled.");
        }
        return orderDataProvider.saveOrder(order);    }
}
