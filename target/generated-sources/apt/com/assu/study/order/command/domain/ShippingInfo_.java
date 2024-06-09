package com.assu.study.order.command.domain;

import com.assu.study.common.model.Address;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ShippingInfo.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class ShippingInfo_ {

	public static final String ADDRESS = "address";
	public static final String RECEIVER = "receiver";
	public static final String MESSAGE = "message";

	
	/**
	 * @see com.assu.study.order.command.domain.ShippingInfo#address
	 **/
	public static volatile SingularAttribute<ShippingInfo, Address> address;
	
	/**
	 * @see com.assu.study.order.command.domain.ShippingInfo#receiver
	 **/
	public static volatile SingularAttribute<ShippingInfo, Receiver> receiver;
	
	/**
	 * @see com.assu.study.order.command.domain.ShippingInfo#message
	 **/
	public static volatile SingularAttribute<ShippingInfo, String> message;
	
	/**
	 * @see com.assu.study.order.command.domain.ShippingInfo
	 **/
	public static volatile EmbeddableType<ShippingInfo> class_;

}

