package com.assu.study.order.query.dao;

import com.assu.study.order.query.dto.OrderSummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql("classpath:shop-init-test.sql")
class OrderSummaryDaoIT {

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
}