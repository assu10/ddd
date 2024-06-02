package com.assu.study.common.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// 밸류 타입
@Getter
@EqualsAndHashCode
public class Email {
    private String address;

    private Email(String address) {
        this.address = address;
    }

    public static Email of(String address) {
        return new Email(address);
    }
}
