package com.assu.study.order.command.domain;

import com.assu.study.catalog.command.domain.product.ProductId;
import com.assu.study.common.jpa.MoneyConverter;
import com.assu.study.common.model.Money;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// 주문 항목
@Embeddable
@Getter
@EqualsAndHashCode  // 밸류 타입
public class OrderLine {
    @Embedded
    private ProductId productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "amounts")
    private Money amounts;

    protected OrderLine() {
    }

    public OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = this.calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
