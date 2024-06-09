package com.assu.study.order.query.dao;

import com.assu.study.order.query.dto.OrderSummary;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderSummaryDao extends Repository<OrderSummary, String> {

    List<OrderSummary> findByOrdererIdOrderByNumberDesc(String ordererId);

    List<OrderSummary> findByOrdererIdOrderByOrderDateDescNumberAsc(String ordererId);

    List<OrderSummary> findByOrdererId(String ordererId, Sort sort);

    // 스펙 인터페이스를 파라메터로 갖는 findAll()
    List<OrderSummary> findAll(Specification<OrderSummary> spec);

    List<OrderSummary> findAll(Specification<OrderSummary> spec, Sort sort);
}
