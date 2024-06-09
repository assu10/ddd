package com.assu.study.catalog.command.domain.category;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CategoryId.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class CategoryId_ {

	public static final String VALUE = "value";

	
	/**
	 * @see com.assu.study.catalog.command.domain.category.CategoryId
	 **/
	public static volatile EmbeddableType<CategoryId> class_;
	
	/**
	 * @see com.assu.study.catalog.command.domain.category.CategoryId#value
	 **/
	public static volatile SingularAttribute<CategoryId, Long> value;

}

