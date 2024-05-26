package com.assu.study.catalog.command.domain.category;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode  // 밸류 타입
@NoArgsConstructor
@Getter
@Embeddable
public class CategoryId implements Serializable {
    private Long value;

    private CategoryId(Long value) {
        this.value = value;
    }

    public static CategoryId of(Long value) {
        return new CategoryId(value);
    }
}
