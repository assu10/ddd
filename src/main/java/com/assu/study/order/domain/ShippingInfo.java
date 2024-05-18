package com.assu.study.order.domain;

import com.assu.study.common.Address;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 배송지 정보
@RequiredArgsConstructor
@Getter
public class ShippingInfo {
    private final Receiver receiver;
    private final Address address;
}