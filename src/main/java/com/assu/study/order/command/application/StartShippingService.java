package com.assu.study.order.command.application;

import com.assu.study.common.VersionConflictException;
import com.assu.study.order.NoOrderException;
import com.assu.study.order.command.domain.Order;
import com.assu.study.order.command.domain.OrderNo;
import com.assu.study.order.command.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StartShippingService {
    private final OrderRepository orderRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public void startShipping(StartShippingRequest req) {
        Optional<Order> oOrder = orderRepository.findById(new OrderNo(req.getOrderNumber()));
        Order order = oOrder.orElseThrow(() -> new NoOrderException());

        // 애그리거트 조회 시점의 버전과 수정 시점의 버전이 일치하지 않으면
        // 누군가 먼저 주문 애그리거트를 수정한 것이므로 예외 발생
        if (!order.matchVersion(req.getVersion())) {
            throw new VersionConflictException();
        }
        order.startShipping();
    }
}
