package com.assu.study.member.query;

import com.assu.study.common.jpa.SpecBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Sql("classpath:shop-init-test.sql")
class MemberDataDaoIT {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MemberDataDao memberDataDao;

    @Test
    void findByNameLike() {
        Sort sort = Sort.by("name").descending();
        // (페이지 넘버, 한 페이지의 개수)
        PageRequest pageReq = PageRequest.of(1, 10, sort);

        List<MemberData> user = memberDataDao.findByNameLike("사용자%", pageReq);
        logger.info("name like result: {}", user.toString());
    }

    @DisplayName("Page 사용")
    @Test
    void findByBlocked() {
        Page<MemberData> page = memberDataDao.findByBlocked(false, PageRequest.of(2, 3));
        logger.info("blocked size: {}", page.getContent().size());

        List<MemberData> content = page.getContent();// 조회 결과 목록

        long totalElements = page.getTotalElements();   // 조건에 해당하는 전체 개수
        int totalPages = page.getTotalPages();  // 전체 페이지 번호
        int number = page.getNumber();  // 현재 페이지 번호
        int numberOfElements = page.getNumberOfElements();  // 조회 결과 개수
        int size = page.getSize();  // 페이지 크기

        logger.info("content.size()={}, totalElements={}, totalPages={}, number={}, numberOfElements={}, size={}",
                content.size(), totalElements, totalPages, number, numberOfElements, size);
    }

    @DisplayName("스펙 빌더 테스트")
    @Test()
    void specBuilder() {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setOnlyNotBlocked(true);

        Specification<MemberData> spec = SpecBuilder.builder(MemberData.class)
                .ifTrue(
                        searchRequest.isOnlyNotBlocked(),
                        () -> MemberDataSpecs.nonBlocked()
                )
                .ifHasText(
                        searchRequest.getName(),
                        name -> MemberDataSpecs.nameLike(searchRequest.getName())
                )
                .toSpec();

        List<MemberData> result = memberDataDao.findAll(spec, PageRequest.of(0, 10));

        logger.info("result: {}", result.size());   // 7
    }

}