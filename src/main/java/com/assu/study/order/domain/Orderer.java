package com.assu.study.order.domain;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode  // 밸류 타입
public class Orderer {
    private final String name;
}
