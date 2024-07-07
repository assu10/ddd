package com.assu.study.member.command.domain;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface MemberRepository extends Repository<Member, MemberId> {
    Optional<Member> findById(MemberId memberId);
}
