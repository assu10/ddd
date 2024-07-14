package com.assu.study.admin.ui;

import com.assu.study.common.VersionConflictException;
import com.assu.study.order.command.application.StartShippingRequest;
import com.assu.study.order.command.application.StartShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class AdminOrderController {
    private StartShippingService startShippingService;

    // 배송 시작으로 상태 변경 시
    @PostMapping("/admin/orders/{orderNo}/shipping")
    public String startShippingOrder(@PathVariable("orderNo") String orderNo,
                                     @RequestParam("version") long version) {
        try {
            startShippingService.startShipping(new StartShippingRequest(orderNo, version));
            return "admin/adminOrderShipped";
        } catch (OptimisticLockingFailureException | VersionConflictException e) {
            // OptimisticLockingFailureException: 누군가 거의 동시에 애그리거트를 수정함 (프레임워크에서 제공하는 예외)
            // VersionConflictException: 이미 누군가 애그리거트를 수정함 (커스텀 예외)
            return "admin/adminOrderLockFail";
        }
    }
}
