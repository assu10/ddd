package com.assu.study.order.command.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// 받는 사람
@Getter
@EqualsAndHashCode  // 밸류 타입
public class Receiver {
    private String name;
    private String phoneNumber;
}
