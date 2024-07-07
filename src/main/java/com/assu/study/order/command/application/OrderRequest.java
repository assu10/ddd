package com.assu.study.order.command.application;

import com.assu.study.member.command.domain.MemberId;
import com.assu.study.order.command.domain.ShippingInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private List<OrderProduct> orderProducts;
    private MemberId ordererMemberId;
    private ShippingInfo shippingInfo;
}
