package com.assu.study.order.domain;

import com.assu.study.common.Money;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// 주문 항목
@Getter
@EqualsAndHashCode  // 밸류 타입
public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = this.calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
