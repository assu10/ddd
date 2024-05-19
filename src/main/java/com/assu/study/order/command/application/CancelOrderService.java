package com.assu.study.order.command.application;

import com.assu.study.order.NoOrderException;
import com.assu.study.order.domain.Order;
import com.assu.study.order.domain.OrderNo;
import com.assu.study.order.domain.OrderRepository;

public class CancelOrderService {
    private OrderRepository orderRepository;

    public void cancel(OrderNo orderNo) {
        Order order = orderRepository.findByNumber(orderNo);
        if (order == null) {
            throw new NoOrderException();
        }
        order.cancel();
        ;
    }
}
