package com.assu.study.order.query.dao;

import com.assu.study.order.query.dto.OrderSummary;
import com.assu.study.order.query.dto.OrderView;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderSummaryDao extends Repository<OrderSummary, String> {

    List<OrderSummary> findByOrdererIdOrderByNumberDesc(String ordererId);

    List<OrderSummary> findByOrdererIdOrderByOrderDateDescNumberAsc(String ordererId);

    List<OrderSummary> findByOrdererId(String ordererId, Sort sort);

    // 스펙 인터페이스를 파라메터로 갖는 findAll()
    List<OrderSummary> findAll(Specification<OrderSummary> spec);

    List<OrderSummary> findAll(Specification<OrderSummary> spec, Sort sort);

    @Query("""
            select new com.assu.study.order.query.dto.OrderView(
            o.number, o.state, m.name, m.id, p.name
            )
            from Order o join o.orderLines ol, Member m, Product  p
            where o.orderer.memberId.id = :ordererId 
            and index(ol) = 0 
            and ol.productId.id = p.id 
            order by o.number.number desc
            """)
    List<OrderView> findOrderView(String ordererId);
}
