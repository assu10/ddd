package com.assu.study.board.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Article.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Article_ {

	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";

	
	/**
	 * @see com.assu.study.board.domain.Article#id
	 **/
	public static volatile SingularAttribute<Article, Long> id;
	
	/**
	 * @see com.assu.study.board.domain.Article#title
	 **/
	public static volatile SingularAttribute<Article, String> title;
	
	/**
	 * @see com.assu.study.board.domain.Article
	 **/
	public static volatile EntityType<Article> class_;
	
	/**
	 * @see com.assu.study.board.domain.Article#content
	 **/
	public static volatile SingularAttribute<Article, ArticleContent> content;

}

