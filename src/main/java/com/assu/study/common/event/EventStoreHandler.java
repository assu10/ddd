package com.assu.study.common.event;

import com.assu.study.eventstore.api.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventStoreHandler {
    private final EventStore eventStore;

    // 모든 이벤트가 공통으로 갖는 프로퍼티를 갖는 공통 추상 클래스인 Event 타입을 상속받은
    // 이벤트 타입만 이벤트 저장소에 보관하기 위해 @EventListener 애너테이션에 값으로 Event.class 설정
    @EventListener(Event.class)
    public void handle(Event event) {
        eventStore.save(event);
    }
}
