package com.assu.study.order.ui;

import com.assu.study.common.ValidationErrorException;
import com.assu.study.member.command.domain.MemberId;
import com.assu.study.order.command.application.OrderRequest;
import com.assu.study.order.command.application.PlaceOrderService;
import com.assu.study.order.command.domain.OrderNo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final PlaceOrderService placeOrderService;

    @PostMapping("/orders/order")
    public String order(@ModelAttribute("orderReq") OrderRequest orderRequest,
                        BindingResult bindingResult,
                        ModelMap modelMap) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderRequest.setOrdererMemberId(MemberId.of(user.getUsername()));
        try {
            OrderNo orderNo = placeOrderService.placeOrder(orderRequest);
            modelMap.addAttribute("orderNo", orderNo.getNumber());
        } catch (ValidationErrorException e) {

            // 응용 서비스가 발생시킨 검증 에러 목록을 뷰에서 사용할 형태로 변환
            e.getErrors().forEach(err -> {
                if (err.hasName()) {
                    bindingResult.rejectValue(err.getName(), err.getCode());
                } else {
                    bindingResult.reject(err.getCode());
                }
            });
        }
        // ...

        return "order/confirm";
    }
}
