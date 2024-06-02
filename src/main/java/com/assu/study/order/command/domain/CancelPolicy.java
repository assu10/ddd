package com.assu.study.order.command.domain;

import org.springframework.stereotype.Component;

@Component
public interface CancelPolicy {
    boolean hasCancellationPermission(Order order, Canceller canceller);
}
