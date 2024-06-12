package com.assu.study.member.query;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        PageRequest pagereq = PageRequest.of(1, 2, sort);

        List<MemberData> user = memberDataDao.findByNameLike("사용자%", pagereq);
        logger.info("name like result: {}", user.toString());
    }
}