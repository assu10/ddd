package com.assu.study.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 배송지 정보
@RequiredArgsConstructor
@Getter
public class ShippingInfo {
    private final String receiverName;
    private final String receiverPhoneNumber;
    private final String shippingAddress1;
    private final String shippingAddress2;
    private final String shippingZipcode;
}