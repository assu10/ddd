package com.assu.study.member.query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MemberDataDao extends Repository<MemberData, String> {
    // 마지막 파라메터로 Pageable 타입을 가짐
    List<MemberData> findByNameLike(String name, Pageable pageable);
}
