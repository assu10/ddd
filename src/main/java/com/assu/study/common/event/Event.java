package com.assu.study.common.event;

import lombok.Getter;

// 모든 이벤트가 공통으로 갖는 프로퍼티를 갖는 공통 추상 클래스
@Getter
public abstract class Event {
    private long timestamp;

    public Event() {
        this.timestamp = System.currentTimeMillis();
    }
}
