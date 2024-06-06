package com.assu.study.catalog.command.domain.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Image 를 상속받은 클래스
@Entity
@DiscriminatorValue("EI")
public class ExternalImage extends Image {
    protected ExternalImage() {
    }

    public ExternalImage(String path) {
        super(path);
    }

    @Override
    public String getURL() {
        return getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return false;
    }

    @Override
    public String getThumbnailURL() {
        return null;
    }
}
