package com.assu.study.order.command.application;

import com.assu.study.order.command.domain.ShippingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChangeShippingRequest {
    private String number;
    private ShippingInfo shippingInfo;
}
