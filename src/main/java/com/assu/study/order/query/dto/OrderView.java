package com.assu.study.order.query.dto;

import com.assu.study.member.command.domain.MemberId;
import com.assu.study.order.command.domain.OrderNo;
import com.assu.study.order.command.domain.OrderState;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OrderView {
    private final String number;
    private final OrderState state;
    private final String memberName;
    private final String memberId;
    private final String productName;

    public OrderView(OrderNo number, OrderState state, String memberName, MemberId memberId, String productName) {
        this.number = number.getNumber();
        this.state = state;
        this.memberName = memberName;
        this.memberId = memberId.getId();
        this.productName = productName;
    }
}
