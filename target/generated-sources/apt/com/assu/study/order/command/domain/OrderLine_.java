package com.assu.study.order.command.domain;

import com.assu.study.catalog.command.domain.product.ProductId;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(OrderLine.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class OrderLine_ {

	public static final String QUANTITY = "quantity";
	public static final String PRODUCT_ID = "productId";

	
	/**
	 * @see com.assu.study.order.command.domain.OrderLine#quantity
	 **/
	public static volatile SingularAttribute<OrderLine, Integer> quantity;
	
	/**
	 * @see com.assu.study.order.command.domain.OrderLine#productId
	 **/
	public static volatile SingularAttribute<OrderLine, ProductId> productId;
	
	/**
	 * @see com.assu.study.order.command.domain.OrderLine
	 **/
	public static volatile EmbeddableType<OrderLine> class_;

}

