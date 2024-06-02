package com.assu.study.order.command.domain;

import lombok.Getter;

@Getter
public class Canceller {
    private String memberId;

    private Canceller(String memberId) {
        this.memberId = memberId;
    }

    public static Canceller of(String memberId) {
        return new Canceller(memberId);
    }
}
