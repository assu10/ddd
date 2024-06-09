package com.assu.study.order.query.dao;

import com.assu.study.order.query.dto.OrderSummary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderSummaryDao extends Repository<OrderSummary, String> {

    // 스펙 인터페이스를 파라메터로 갖는 findAll()
    List<OrderSummary> findAll(Specification<OrderSummary> spec);
}
