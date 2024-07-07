package com.assu.study.member.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

// 밸류 타입
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class MemberId implements Serializable {
    @Column(name = "member_id")
    private String id;

    protected MemberId() {
    }

    private MemberId(String id) {
        new MemberId(id);
    }

    public static MemberId of(String id) {
        return new MemberId(id);
    }
}
