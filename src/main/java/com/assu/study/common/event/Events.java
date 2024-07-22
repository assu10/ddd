package com.assu.study.common.event;

import org.springframework.context.ApplicationEventPublisher;

public class Events {
    private static ApplicationEventPublisher publisher;

    // Events 클래스가 사용할 ApplicationEventPublisher 객체는 setPublisher() 를 통해 전달받음
    static void setPublisher(ApplicationEventPublisher publisher) {
        Events.publisher = publisher;
    }

    // ApplicationEventPublisher 가 제공하는 publishEvent() 메서드를 이용하여 이벤트 발생
    public static void raise(Object event) {
        if (publisher != null) {
            publisher.publishEvent(event);
        }
    }
}
