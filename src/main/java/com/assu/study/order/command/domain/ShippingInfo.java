package com.assu.study.order.command.domain;

import com.assu.study.common.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// 배송지 정보
@AllArgsConstructor
@Getter
@EqualsAndHashCode  // 밸류 타입
@Embeddable
public class ShippingInfo {
    @Column(name = "shipping_message")
    private String message;

    @Embedded
    private Receiver receiver;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zip_code")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2"))
    })
    private Address address;

    protected ShippingInfo() {
    }
}