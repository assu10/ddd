package com.assu.study.order.command.domain;

import lombok.Getter;

// 배송지 변경 시 발생하는 이벤트
@Getter
public class ShippingInfoChangedEvent {
    private final OrderNo number;
    private final ShippingInfo newShippingInfo;
    private long timestamp;

    public ShippingInfoChangedEvent(OrderNo number, ShippingInfo newShippingInfo) {
        super();
        this.number = number;
        this.newShippingInfo = newShippingInfo;
        this.timestamp = System.currentTimeMillis();
    }
}