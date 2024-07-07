package com.assu.study.member.command.domain;

import com.assu.study.common.jpa.EmailSetConverter;
import com.assu.study.common.model.EmailSet;
import jakarta.persistence.*;
import lombok.Getter;

// 회원 (애그리거트 루트), 변경 모델
@Getter
@Entity
@Table(name = "member")
public class Member {
    @EmbeddedId
    private MemberId id;

    private String name;

    @Embedded
    private Password password;

    private boolean blocked;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emails;

    protected Member() {
    }

    public Member(MemberId id, String name) {
        this.id = id;
        this.name = name;
    }

    public void changePassword(String currentPassword, String newPassword) {
        // 현재 암호와 일치하는지 검사
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchingException();
        }

        // 밸류 타입의 데이터를 변경할 때는 새로운 객체로 교체함
        this.password = new Password(newPassword);
    }
}
