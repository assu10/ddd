package com.assu.study.member.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberDataDao extends Repository<MemberData, String> {

    // 마지막 파라메터로 Pageable 타입을 가짐
    List<MemberData> findByNameLike(String name, Pageable pageable);

    // 리턴 타입이 Page 이면 전체 개수, 페이지 개수 등의 데이터도 제공
    Page<MemberData> findByBlocked(boolean blocked, Pageable pageable);

    // 스펙 사용시에도 Pageagle 사용 가능
    List<MemberData> findAll(Specification<MemberData> spec, Pageable pageable);

    // 이름을 Like 로 검색한 결과를 이름 기준으로 오름차순으로 정렬 후 처음 3개 리턴
    List<MemberData> findFirst3ByNameLikeOrderByName(String name);

    Optional<MemberData> findFirstByNameLikeOrderByName(String name);

    Optional<MemberData> findTopByNameLikeOrderByName(String name);


}
