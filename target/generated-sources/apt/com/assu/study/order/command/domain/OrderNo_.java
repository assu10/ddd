package com.assu.study.order.command.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(OrderNo.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class OrderNo_ {

	public static final String NUMBER = "number";

	
	/**
	 * @see com.assu.study.order.command.domain.OrderNo#number
	 **/
	public static volatile SingularAttribute<OrderNo, String> number;
	
	/**
	 * @see com.assu.study.order.command.domain.OrderNo
	 **/
	public static volatile EmbeddableType<OrderNo> class_;

}

