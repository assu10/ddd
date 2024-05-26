package com.assu.study.catalog.command.domain.product;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode  // 밸류 타입
@NoArgsConstructor
@Getter
@Embeddable
public class ProductId implements Serializable {
    private String id;

    private ProductId(String id) {
        this.id = id;
    }

    public static ProductId of(String id) {
        return new ProductId(id);
    }
}
