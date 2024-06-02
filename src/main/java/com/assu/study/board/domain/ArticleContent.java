package com.assu.study.board.domain;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Embeddable
@Access(AccessType.FIELD)
public class ArticleContent {
    private String content;
    private String contentType;

    protected ArticleContent() {
    }
}
