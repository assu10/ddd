package com.assu.study.order.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode  // 밸류 타입
public class OrderNo {
    private final String number;
}