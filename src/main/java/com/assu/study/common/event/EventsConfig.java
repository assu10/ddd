package com.assu.study.common.event;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class EventsConfig {
    private final ApplicationContext applicationContext;

    // InitializingBean 타입 객체를 빈으로 설정
    // 이 타입은 스프링 빈 객체를 초기화할 때 사용하는 인터페이스로
    // 이 기능을 사용해서 Events 클래스를 초기화함
    @Bean
    public InitializingBean eventInitializer() {
        // ApplicationContext 는 ApplicationEventPublisher 를 상속하고 있으므로
        // Events 클래스 초기화 시 ApplicationContext 전달
        return () -> Events.setPublisher(applicationContext);
    }
}
