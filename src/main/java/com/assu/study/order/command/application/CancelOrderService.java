package com.assu.study.order.command.application;

import com.assu.study.order.NoOrderException;
import com.assu.study.order.command.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CancelOrderService {
    private final OrderRepository orderRepository;
    private final CancelPolicy cancelPolicy;

    @Transactional
    public void cancel(OrderNo orderNo, Canceller canceller) {
        Order order = orderRepository.findById(orderNo)
                .orElseThrow(() -> new NoOrderException());
        if (!cancelPolicy.hasCancellationPermission(order, canceller)) {
            throw new NoCancellablePermission();
        }
        order.cancel();
    }
}
