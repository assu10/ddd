package com.assu.study.order.query.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(OrderSummary.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class OrderSummary_ {

	public static final String NUMBER = "number";
	public static final String TOTAL_AMOUNTS = "totalAmounts";
	public static final String PRODUCT_ID = "productId";
	public static final String ORDERER_ID = "ordererId";
	public static final String RECEIVER_NAME = "receiverName";
	public static final String STATE = "state";
	public static final String VERSION = "version";
	public static final String ORDERER_NAME = "ordererName";
	public static final String ORDER_DATE = "orderDate";
	public static final String PRODUCT_NAME = "productName";

	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#number
	 **/
	public static volatile SingularAttribute<OrderSummary, String> number;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#totalAmounts
	 **/
	public static volatile SingularAttribute<OrderSummary, Integer> totalAmounts;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#productId
	 **/
	public static volatile SingularAttribute<OrderSummary, String> productId;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#ordererId
	 **/
	public static volatile SingularAttribute<OrderSummary, String> ordererId;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#receiverName
	 **/
	public static volatile SingularAttribute<OrderSummary, String> receiverName;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#state
	 **/
	public static volatile SingularAttribute<OrderSummary, String> state;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary
	 **/
	public static volatile EntityType<OrderSummary> class_;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#version
	 **/
	public static volatile SingularAttribute<OrderSummary, Long> version;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#ordererName
	 **/
	public static volatile SingularAttribute<OrderSummary, String> ordererName;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#orderDate
	 **/
	public static volatile SingularAttribute<OrderSummary, LocalDateTime> orderDate;
	
	/**
	 * @see com.assu.study.order.query.dto.OrderSummary#productName
	 **/
	public static volatile SingularAttribute<OrderSummary, String> productName;

}

