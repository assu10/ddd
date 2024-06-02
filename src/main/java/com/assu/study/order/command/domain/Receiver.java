package com.assu.study.order.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 받는 사람
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode  // 밸류 타입
@Embeddable
public class Receiver {
    @Column(name = "receiver_name")
    private String name;

    @Column(name = "receiver_phone")
    private String phoneNumber;
}
