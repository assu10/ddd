package com.assu.study.integration;

// OffsetStore 를 구현하는 클래스는 offset 값을 DB 에 저장하거나 로컬 파일에 보관하여
// 마지막 offset 값을 물리적 저장소에 보관해야 함
public interface OffsetStore {
    long get();

    void update(long nextOffset);
}
