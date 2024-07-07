package com.assu.study.member.command.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TmpChangePasswordService {
    private final MemberRepository memberRepository;

    public void changePassword(MemberId memberId, String oldPw, String newPw) {
        Optional<Member> member = memberRepository.findById(memberId);
        //checkMemberExists(member);
        member.get().changePassword(oldPw, newPw);
    }
}
