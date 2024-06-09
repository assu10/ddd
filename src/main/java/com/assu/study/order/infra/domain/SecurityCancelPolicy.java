package com.assu.study.order.infra.domain;

import com.assu.study.order.command.domain.CancelPolicy;
import com.assu.study.order.command.domain.Canceller;
import com.assu.study.order.command.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class SecurityCancelPolicy implements CancelPolicy {
    @Override
    public boolean hasCancellationPermission(Order order, Canceller canceller) {
        // 구현체가 필요하기 때문에 임시로 생성한 파일
        return false;
    }
}
