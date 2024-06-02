package com.assu.study.order.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode  // 밸류 타입
@Getter
@AllArgsConstructor
@Embeddable // 키 클래스
public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String number;

    protected OrderNo() {
    }
}
