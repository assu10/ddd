package com.assu.study.order.command.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode  // 밸류 타입
public class Orderer {
    private final String name;
}
