package com.assu.study.eventstore.infra;

import com.assu.study.eventstore.api.EventEntry;
import com.assu.study.eventstore.api.EventStore;
import com.assu.study.eventstore.api.PayloadConvertException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;


// JDBC 를 이용한 EventStore 구현 클래스
@RequiredArgsConstructor
@Component
public class JdbcEventStore implements EventStore {

    private final ObjectMapper objectMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Object event) {
        // EventEntry 객체 생성
        // event 객체를 JSON 문자열로 변환하여 payload 에 전달
        EventEntry entry = new EventEntry(event.getClass().getName(), MediaType.APPLICATION_JSON_VALUE, toJson(event));

        jdbcTemplate.update(
                "INSERT INTO evententry (type, content_type, payload, timestamp) " +
                        "VALUES (?, ?, ?, ?)",
                ps -> {
                    ps.setString(1, entry.getType());
                    ps.setString(2, entry.getContentType());
                    ps.setString(3, entry.getPayload());
                    ps.setTimestamp(4, new Timestamp(entry.getTimestamp()));
                }
        );
    }

    private String toJson(Object event) {
        try {
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new PayloadConvertException(e);
        }
    }

    @Override
    public List<EventEntry> get(long offset, long limit) {
        return jdbcTemplate.query(
                "SELECT * FROM evententry ORDER BY id ASC LIMIT ?, ?",
                ps -> {
                    ps.setLong(1, offset);
                    ps.setLong(2, limit);
                },
                (rs, rowNum) -> new EventEntry(
                        rs.getLong("id"),
                        rs.getString("type"),
                        rs.getString("content_type"),
                        rs.getString("payload"),
                        rs.getTimestamp("timestamp").getTime()
                )
        );
    }
}
