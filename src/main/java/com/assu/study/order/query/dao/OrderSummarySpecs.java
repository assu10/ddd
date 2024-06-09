package com.assu.study.order.query.dao;

import com.assu.study.order.query.dto.OrderSummary;
import com.assu.study.order.query.dto.OrderSummary_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

// OrderSummary 에 관련된 스펙 생성 기능을 하나로 모은 클래스
public class OrderSummarySpecs {
    public static Specification<OrderSummary> ordererId(String ordererId) {
        return (Root<OrderSummary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.equal(root.get(OrderSummary_.ordererId), ordererId);
    }

    public static Specification<OrderSummary> orderDateBetween(LocalDateTime from, LocalDateTime to) {
        return (Root<OrderSummary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.between(root.get(OrderSummary_.orderDate), from, to);
    }
}
