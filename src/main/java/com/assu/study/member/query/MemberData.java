package com.assu.study.member.query;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

// 회원 (애그리거트 루트), 조회 모델
@Getter
@Entity
@Table(name = "member")
public class MemberData {
    @Id
    @Column(name = "member_id")
    private String id;

    private String name;

    private boolean blocked;

    protected MemberData() {
    }

    public MemberData(String id, String name, boolean blocked) {
        this.id = id;
        this.name = name;
        this.blocked = blocked;
    }
}
