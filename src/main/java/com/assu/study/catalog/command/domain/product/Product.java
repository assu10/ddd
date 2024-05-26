package com.assu.study.catalog.command.domain.product;

import com.assu.study.catalog.command.domain.category.CategoryId;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @EmbeddedId
    private ProductId id;

    @ElementCollection  // 값 타입 컬렉션
    @CollectionTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id")) // 테이블명 지정
    private Set<CategoryId> categoryIds;
}
