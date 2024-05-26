package com.assu.study.member.command.domain;

// 회원 (애그리거트 루트)
public class Member {
    private Password password;

    public void changePassword(String currentPassword, String newPassword) {
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchingException();
        }

        // 밸류 타입의 데이터를 변경할 때는 새로운 객체로 교체함
        this.password = new Password(newPassword);
    }
}
