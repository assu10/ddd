package com.assu.study.catalog.command.domain.product;

import com.assu.study.catalog.command.domain.category.CategoryId;
import com.assu.study.common.jpa.MoneyConverter;
import com.assu.study.common.model.Money;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @EmbeddedId
    private ProductId id;

    @ElementCollection(fetch = FetchType.LAZY)  // 값 타입 컬렉션
    @CollectionTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id")) // 테이블명 지정
    private Set<CategoryId> categoryIds;

    private String name;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    private String detail;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},    // Product 의 저장/삭제 시 함께 저장 삭제
            orphanRemoval = true,   // 리스트에서 Image 객체 제거 시 DB 에서도 함께 삭제
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    protected Product() {

    }

    public Product(ProductId id, String name, Money price, String detail, List<Image> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.images.addAll(images);
    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public List<Image> getImages() {
        return Collections.unmodifiableList(images);
    }

    // 이미지 변경
    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }

    public String getFirstImageThumbnailPath() {
        if (images == null || images.isEmpty()) {
            return null;
        }
        return images.get(0).getThumbnailURL();
    }
}
