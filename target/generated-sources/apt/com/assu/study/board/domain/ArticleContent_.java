package com.assu.study.board.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ArticleContent.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class ArticleContent_ {

	public static final String CONTENT_TYPE = "contentType";
	public static final String CONTENT = "content";

	
	/**
	 * @see com.assu.study.board.domain.ArticleContent
	 **/
	public static volatile EmbeddableType<ArticleContent> class_;
	
	/**
	 * @see com.assu.study.board.domain.ArticleContent#contentType
	 **/
	public static volatile SingularAttribute<ArticleContent, String> contentType;
	
	/**
	 * @see com.assu.study.board.domain.ArticleContent#content
	 **/
	public static volatile SingularAttribute<ArticleContent, String> content;

}

