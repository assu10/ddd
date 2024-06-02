package com.assu.study.common.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 밸류 타입
public class EmailSet {
    private Set<Email> emails = new HashSet<>();

    public EmailSet(Set<Email> emails) {
        this.emails.addAll(emails);
    }

    public Set<Email> getEmails() {
        return Collections.unmodifiableSet(emails);
    }
}
