package com.assu.study.member.command.application;

import com.assu.study.member.command.domain.Member;
import com.assu.study.member.command.domain.MemberId;
import com.assu.study.member.command.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BlockMemberService {
    private final MemberRepository memberRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public void block(String memberId) {
        Member member = memberRepository.findById(MemberId.of(memberId))
                .orElseThrow(() -> new NoMemberException());

        member.block();
    }
}
