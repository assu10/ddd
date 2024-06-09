package com.assu.study.order.command.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Order.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Order_ {

	public static final String NUMBER = "number";
	public static final String ORDER_LINES = "orderLines";
	public static final String ORDERER = "orderer";
	public static final String SHIPPING_INFO = "shippingInfo";
	public static final String STATE = "state";

	
	/**
	 * @see com.assu.study.order.command.domain.Order#number
	 **/
	public static volatile SingularAttribute<Order, OrderNo> number;
	
	/**
	 * @see com.assu.study.order.command.domain.Order#orderLines
	 **/
	public static volatile ListAttribute<Order, OrderLine> orderLines;
	
	/**
	 * @see com.assu.study.order.command.domain.Order#orderer
	 **/
	public static volatile SingularAttribute<Order, Orderer> orderer;
	
	/**
	 * @see com.assu.study.order.command.domain.Order#shippingInfo
	 **/
	public static volatile SingularAttribute<Order, ShippingInfo> shippingInfo;
	
	/**
	 * @see com.assu.study.order.command.domain.Order#state
	 **/
	public static volatile SingularAttribute<Order, OrderState> state;
	
	/**
	 * @see com.assu.study.order.command.domain.Order
	 **/
	public static volatile EntityType<Order> class_;

}

