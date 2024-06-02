package com.assu.study.member.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode  // 밸류 타입
public class Password {
    @Column(name = "password")
    private String value;

    protected Password() {
    }

    public Password(String value) {
        this.value = value;
    }

    // 기존 암호와 일치하는지 확인
    public boolean match(String password) {
        return this.value.equals(password);
    }
}
