package com.assu.study.order;

// 주문 상태 표현
public enum OrderState {
    PAYMENT_WAITING,
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED;
}
