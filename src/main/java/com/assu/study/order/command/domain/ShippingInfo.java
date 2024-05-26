package com.assu.study.order.command.domain;

import com.assu.study.common.Address;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 배송지 정보
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode  // 밸류 타입
public class ShippingInfo {
    private final Receiver receiver;
    private final Address address;
}