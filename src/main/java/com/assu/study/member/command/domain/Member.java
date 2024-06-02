package com.assu.study.member.command.domain;

import com.assu.study.common.jpa.EmailSetConverter;
import com.assu.study.common.model.EmailSet;
import jakarta.persistence.*;

// 회원 (애그리거트 루트)
@Entity
@Table(name = "member")
public class Member {
    @EmbeddedId
    private MemberId id;

    @Embedded
    private Password password;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emails;

    public void changePassword(String currentPassword, String newPassword) {
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchingException();
        }

        // 밸류 타입의 데이터를 변경할 때는 새로운 객체로 교체함
        this.password = new Password(newPassword);
    }
}
