package com.assu.study.eventstore.api;

import java.util.List;

// 이벤트 객체를 직렬화하여 EventEntry 의 payload 에 저장하는 인터페이스
// 이벤트를 저장하고 조회하는 인터페이스 제공
public interface EventStore {
    void save(Object event);

    List<EventEntry> get(long offset, long limit);
}
