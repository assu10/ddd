package com.assu.study.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;

// locks 테이블의 데이터를 담는 클래스
@AllArgsConstructor
@Getter
public class LockData {
    private String type;
    private String id;
    private String lockId;
    private long timestamp;

    // 잠금 유효시간이 지났는지 판단
    public boolean isExpired() {
        return timestamp < System.currentTimeMillis();
    }
}
