package com.assu.study.integration;

import com.assu.study.eventstore.api.EventEntry;
import com.assu.study.eventstore.api.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EventForwarder {
    private static final int DEFAULT_LIMIT_SIZE = 100;
    private final EventStore eventStore;    // 이벤트를 저장하고 조회하는 인터페이스
    private final OffsetStore offsetStore;
    private final EventSender eventSender;
    private int limitSize = DEFAULT_LIMIT_SIZE;

    @Scheduled(initialDelay = 1000L, fixedDelay = 1000L)
    public void getAndSend() {
        // 읽어올 이벤트의 다음 offset 조회
        long nextOffset = getNextOffset();

        // 이벤트 저장소에서 offset 부터 limitSize 만큼 이벤트 구함
        List<EventEntry> events = eventStore.get(nextOffset, limitSize);

        // 구한 이벤트가 존재하는지 검사
        if (!events.isEmpty()) {
            // 이벤트 전송
            int processedCount = sendEvent(events);

            // 처리한 이벤트 개수가 0보다 크면 ㅁ다음에 읽어올 offset 저장
            if (processedCount > 0) {
                saveNextOffset(nextOffset + processedCount);
            }
        }
    }

    private long getNextOffset() {
        return offsetStore.get();
    }

    private int sendEvent(List<EventEntry> events) {
        int processedCount = 0;

        // 이벤트를 차례대로 발송함
        // 예외가 발생하면 이벤트 전송을 멈추고 전송에 성공한 이벤트의 개수 리턴
        // 따라서 다음번 getAndSend() 메서드를 실행하면
        // 마지막으로 전송에 성공한 이벤트의 다음 이벤트부터 읽어와서 전송 시도
        try {
            for (EventEntry entry : events) {
                eventSender.send(entry);
                processedCount++;
            }
        } catch (Exception e) {
            // 로깅 처리
        }
        return processedCount;
    }

    private void saveNextOffset(long nextOffset) {
        offsetStore.update(nextOffset);
    }
}
