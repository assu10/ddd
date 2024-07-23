package com.assu.study.order.infra;

import com.assu.study.order.command.application.RefundService;
import com.assu.study.order.command.domain.OrderCanceledEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

// OrderCanceledEvent 처리하는 핸들러
@RequiredArgsConstructor
@Service
public class OrderCanceledEventHandler {
    private final RefundService refundService;

    @Async
    //@EventListener(OrderCanceledEvent.class)
    @TransactionalEventListener(
            classes = OrderCanceledEvent.class,
            phase = TransactionPhase.AFTER_COMMIT   // 트랜잭션 커밋이 성공한 뒤 핸들러 메서드 실행
    )
    public void handle(OrderCanceledEvent event) {
        refundService.refund(event.getOrderNumber());
    }
}
