package com.assu.study.order.command.domain;

public interface OrderRepository {
    Order findByNumber(OrderNo number);

    void save(Order order);
}
