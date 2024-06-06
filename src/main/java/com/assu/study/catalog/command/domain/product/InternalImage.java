package com.assu.study.catalog.command.domain.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Image 를 상속받은 클래스
@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image {
    protected InternalImage() {
    }

    public InternalImage(String path) {
        super(path);
    }

    @Override
    public String getURL() {
        return "/images/original/" + getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return true;
    }

    @Override
    public String getThumbnailURL() {
        return "/images/thumbnail/" + getPath();
    }
}
