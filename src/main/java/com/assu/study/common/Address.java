package com.assu.study.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode  // 밸류 타입
@Getter
public class Address {
    private String address1;
    private String address2;
    private String zipcode;
}
