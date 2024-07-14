package com.assu.study.lock;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LockingFailException extends LockException {
    public LockingFailException(Exception cause) {
        super(cause);
    }
}
