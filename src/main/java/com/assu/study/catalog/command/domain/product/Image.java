package com.assu.study.catalog.command.domain.product;


import jakarta.persistence.*;

import java.time.LocalDateTime;

// 밸류를 @Entity 로 매핑했으므로 상태 변경 메서드는 제공하지 않음
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "image_type")
@Table(name = "image")
public abstract class Image {   // 추상 클래스임
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_path")
    private String path;

    @Column(name = "upload_time")
    private LocalDateTime uploadTime;

    protected Image() {
    }

    public Image(String path) {
        this.path = path;
        this.uploadTime = LocalDateTime.now();
    }

    protected String getPath() {
        return path;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    // 이 클래스를 상속받는 클래스에서 구현할 메서드들
    public abstract String getURL();

    public abstract boolean hasThumbnail();

    public abstract String getThumbnailURL();
}
