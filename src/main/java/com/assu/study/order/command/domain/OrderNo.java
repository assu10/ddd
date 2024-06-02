package com.assu.study.order.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode  // 밸류 타입
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Embeddable // 키 클래스
public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String number;
}
