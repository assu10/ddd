package com.assu.study.order.query.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import java.time.LocalDateTime;

@Entity
@Immutable  // 실수로 매핑 필드/프로퍼티가 수정되어도 DB 에 반영하지 않음
@Subselect(
        """
                select o.order_number as number,
                       o.version,
                       o.orderer_id,
                       o.orderer_name,
                       o.total_amounts,
                       o.receiver_name,
                       o.state,
                       o.order_date,
                       p.product_id,
                       p.name         as product_name
                from purchase_order o
                         inner join order_line ol
                                    on o.order_number = ol.order_number
                         cross join product p
                where ol.line_idx = 0
                  and ol.product_id = p.product_id;
                                """
)
// 아래 3개 테이블에 변경사항이 있으면 OrderSummary 엔티티 로딩 전에 변경 내역을 먼저 flush 한 후 OrderSummary 엔티티 로
@Synchronize({"purchase_order", "order_line", "product"})
@Getter
public class OrderSummary {
    @Id
    private String number;

    private long version;

    @Column(name = "orderer_id")
    private String ordererId;

    @Column(name = "orderer_name")
    private String ordererName;

    @Column(name = "total_amounts")
    private int totalAmounts;

    @Column(name = "receiver_name")
    private String receiverName;

    private String state;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    protected OrderSummary() {
    }
}
