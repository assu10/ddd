package com.assu.study.order.query.dao;

import com.assu.study.order.query.dto.OrderSummary;
import com.assu.study.order.query.dto.OrderSummary_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
// Specification<OrderSummary> 을 구현하므로 OrderSummary 에 대한 검색 조건을 표현함
public class OrdererIdSpec implements Specification<OrderSummary> {
    private String ordererId;

    @Override
    public Predicate toPredicate(Root<OrderSummary> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        // ordererId 프로퍼티 값이 생성자로 전달받은 ordererId 와 동일한지 비교하는 Predicate 생성
        return criteriaBuilder.equal(root.get(OrderSummary_.ordererId), ordererId);
    }
}
