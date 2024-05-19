package com.assu.study.order.domain;

public interface OrderRepository {
    Order findByNumber(OrderNo number);

    void save(Order order);
}
