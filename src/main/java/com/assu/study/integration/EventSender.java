package com.assu.study.integration;

import com.assu.study.eventstore.api.EventEntry;

// 이 인페이스를 구현하는 클래스는 send() 메서드에서 외부 메시징 시스템에 이벤트를 전송하거나
// 원하는 핸들러에 이벤트를 전달하면 됨

// 이벤트 처리 중 예외가 발생하면 그대로 전파하여 다으 주기에 getAndSend() 메서드를 실행할 때 재처리할 수 있도록 해야 함
public interface EventSender {
    void send(EventEntry event);
}
