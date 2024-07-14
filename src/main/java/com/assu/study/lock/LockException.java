package com.assu.study.lock;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LockException extends RuntimeException {
    public LockException(String message) {
        super(message);
    }

    public LockException(Throwable cause) {
        super(cause);
    }
}
