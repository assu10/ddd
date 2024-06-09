package com.assu.study.catalog.command.domain.product;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductId.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class ProductId_ {

	public static final String ID = "id";

	
	/**
	 * @see com.assu.study.catalog.command.domain.product.ProductId#id
	 **/
	public static volatile SingularAttribute<ProductId, String> id;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.ProductId
	 **/
	public static volatile EmbeddableType<ProductId> class_;

}

