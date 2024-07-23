package com.assu.study.integration.infra;

import com.assu.study.eventstore.api.EventEntry;
import com.assu.study.integration.EventSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SysoutEventSender implements EventSender {
    @Override
    public void send(EventEntry event) {
        log.info("EventSender send event: {}", event);
    }
}
