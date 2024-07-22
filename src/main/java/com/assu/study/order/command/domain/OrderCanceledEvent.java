package com.assu.study.order.command.domain;

import com.assu.study.common.event.Event;
import lombok.Getter;

// 발생 시간이 필요한 이벤트 클래스는 Event 클래스를 상속받아 구현함
@Getter
public class OrderCanceledEvent extends Event {
    // 이벤트는 핸들러에서 이벤트를 처리하는데 필요한 데이터를 포함함
    private String orderNumber;

    public OrderCanceledEvent(String orderNumber) {
        super();
        this.orderNumber = orderNumber;
    }
}
