package com.assu.study.order;

import lombok.Getter;

// 주문 항목
@Getter
public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = this.calculateAmounts();
    }

    private int calculateAmounts() {
        return price * quantity;
    }
}
