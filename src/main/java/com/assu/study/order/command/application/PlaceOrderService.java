package com.assu.study.order.command.application;

import com.assu.study.catalog.command.domain.product.ProductRepository;
import com.assu.study.common.ValidationError;
import com.assu.study.common.ValidationErrorException;
import com.assu.study.order.command.domain.OrderNo;
import com.assu.study.order.command.domain.OrderRepository;
import com.assu.study.order.command.domain.OrdererService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceOrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrdererService ordererService;

    @Transactional
    public OrderNo placeOrder(OrderRequest orderRequest) {
        List<ValidationError> errors = new ArrayList<>();
        if (orderRequest == null) {
            errors.add(ValidationError.of("empty"));
        } else {
            if (orderRequest.getOrdererMemberId() == null) {
                errors.add(ValidationError.of("ordererMemberId", "empty"));
            }
            if (orderRequest.getOrderProducts() == null) {
                errors.add(ValidationError.of("orderProducts", "empty"));
            }
            if (orderRequest.getOrderProducts().isEmpty()) {
                errors.add(ValidationError.of("orderProducts", "empty"));
            }

            // 응용 서비스가 입력 오률ㄹ 하나의 익셉션으로 모아서 발생시킴
            if (!errors.isEmpty()) {
                throw new ValidationErrorException(errors);
            }
        }

        // ...

        return orderRepository.nextOrderNo();
    }
}
