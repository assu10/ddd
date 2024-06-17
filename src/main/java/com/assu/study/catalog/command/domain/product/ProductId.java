package com.assu.study.catalog.command.domain.product;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

// 밸류 타입
@Embeddable
@Getter
@EqualsAndHashCode
@Access(AccessType.FIELD)
public class ProductId implements Serializable {
    @Column(name = "product_id")
    private String id;

    protected ProductId() {
    }

    public ProductId(String id) {
        this.id = id;
    }

    public static ProductId of(String id) {
        return new ProductId(id);
    }
}
