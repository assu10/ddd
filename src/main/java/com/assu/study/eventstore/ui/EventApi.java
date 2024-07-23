package com.assu.study.eventstore.ui;

import com.assu.study.eventstore.api.EventEntry;
import com.assu.study.eventstore.api.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EventApi {
    private final EventStore eventStore;

    @GetMapping("/api/events")
    public List<EventEntry> list(
            @RequestParam("offset") Long offset,
            @RequestParam("limit") Long limit
    ) {
        return eventStore.get(offset, limit);
    }
}
