package com.assu.study.order.query.dao;

import com.assu.study.order.query.dto.OrderSummary;
import com.assu.study.order.query.dto.OrderView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql("classpath:shop-init-test.sql")
class OrderSummaryDaoIT {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderSummaryDao orderSummaryDao;

    @Test
    void findAllSpec() {
        LocalDateTime from = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2022, 1, 2, 0, 0, 0);

        Specification<OrderSummary> spec = OrderSummarySpecs.ordererId("user1")
                .and(OrderSummarySpecs.orderDateBetween(from, to));

        List<OrderSummary> orderSummaryList = orderSummaryDao.findAll(spec);
        assertThat(orderSummaryList).hasSize(1);
    }

    @Test
    void findByOrdererIdSort() {
        Sort sort = Sort.by("number").descending();
        List<OrderSummary> orderSummaryList = orderSummaryDao.findByOrdererId("user1", sort);

        assertThat(orderSummaryList.get(0).getNumber()).isEqualTo("ORDER-002");
        assertThat(orderSummaryList.get(1).getNumber()).isEqualTo("ORDER-001");
    }

    @Test
    void findByOrdererIdSort2() {
        Sort sort1 = Sort.by("number").descending();
        Sort sort2 = Sort.by("orderDate").ascending();
        Sort sort = sort1.and(sort2);
        List<OrderSummary> orderSummaryList = orderSummaryDao.findByOrdererId("user1", sort);

        assertThat(orderSummaryList.get(0).getNumber()).isEqualTo("ORDER-002");
        assertThat(orderSummaryList.get(1).getNumber()).isEqualTo("ORDER-001");
    }

    @DisplayName("@Subselect 를 @Entity 처럼 사용")
    @Test
    void findAllSpecPageable() {
        LocalDateTime from = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2023, 1, 2, 0, 0, 0);

        // @Subselect 를 적용한 @Entity 는 일반 @Entity 와 동일한 방법으로 조회 가능
        Specification<OrderSummary> spec = OrderSummarySpecs.orderDateBetween(from, to);
        Pageable pageable = PageRequest.of(1, 1);
        List<OrderSummary> results = orderSummaryDao.findAll(spec, pageable);
        logger.info("results: {}", results);
        assertThat(results).hasSize(1);
    }

    @DisplayName("동적 인스턴스 생성 테스트")
    @Test
    void findOrderView() {
        List<OrderView> result = orderSummaryDao.findOrderView("user1");
        // result: [OrderView(number=ORDER-002, state=PREPARING, memberName=사용자1, memberId=user1, productName=라즈베리파이3 모델B), OrderView(number=ORDER-001, state=PREPARING, memberName=사용자1, memberId=user1, productName=라즈베리파이3 모델B)]
        logger.info("result: {}", result);
    }
}