package com.assu.study.member.command.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode  // 밸류 타입
public class Password {
    private final String value;

    // 기존 암호와 일치하는지 확인
    public boolean match(String password) {
        return this.value.equals(password);
    }
}
