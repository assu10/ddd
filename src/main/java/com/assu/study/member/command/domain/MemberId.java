package com.assu.study.member.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

// 밸류 타입
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@Embeddable
public class MemberId implements Serializable {
    @Column(name = "member_id")
    private String id;

    protected MemberId() {
    }
}
