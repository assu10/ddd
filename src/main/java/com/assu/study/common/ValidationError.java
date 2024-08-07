package com.assu.study.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ValidationError {
    private final String name;
    private final String code;

    public static ValidationError of(String code) {
        return new ValidationError(null, code);
    }

    public static ValidationError of(String name, String code) {
        return new ValidationError(name, code);
    }

    public boolean hasName() {
        return name != null;
    }
}
