package com.assu.study.order.infra;

import com.assu.study.order.command.application.RefundService;
import com.assu.study.order.command.domain.OrderCanceledEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

// OrderCanceledEvent 처리하는 핸들러
@RequiredArgsConstructor
@Service
public class OrderCanceledEventHandler {
    private final RefundService refundService;

    @EventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent event) {
        refundService.refund(event.getOrderNumber());
    }
}
