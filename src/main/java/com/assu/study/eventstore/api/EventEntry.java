package com.assu.study.eventstore.api;

import lombok.AllArgsConstructor;
import lombok.Getter;


// 이벤트 저장소에 보관할 데이터
@AllArgsConstructor
@Getter
public class EventEntry {
    private Long id;    // 이벤트 식별자
    private String type;    // 이벤트 타입
    private String contentType; // 직렬화한 데이터 형식
    private String payload; // 이벤트 데이터 자체
    private long timestamp; // 이벤트 시간

    public EventEntry(String type, String contentType, String payload) {
        this.type = type;
        this.contentType = contentType;
        this.payload = payload;
        this.timestamp = System.currentTimeMillis();
    }
}
