package com.assu.study.member.query;

import org.springframework.data.jpa.domain.Specification;

// MemberData 에 관련된 스펙 생성 기능을 하나로 모은 클래스
public class MemberDataSpecs {
    public static Specification<MemberData> nonBlocked() {
        return (root, query, cb) -> cb.equal(root.get("blocked"), false);
    }

    public static Specification<MemberData> nameLike(String keyword) {
        return (root, query, cb) -> cb.like(root.get("name"), keyword + "%");
    }
}
