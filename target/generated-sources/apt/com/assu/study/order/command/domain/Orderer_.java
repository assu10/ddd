package com.assu.study.order.command.domain;

import com.assu.study.member.command.domain.MemberId;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Orderer.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Orderer_ {

	public static final String NAME = "name";
	public static final String MEMBER_ID = "memberId";

	
	/**
	 * @see com.assu.study.order.command.domain.Orderer#name
	 **/
	public static volatile SingularAttribute<Orderer, String> name;
	
	/**
	 * @see com.assu.study.order.command.domain.Orderer
	 **/
	public static volatile EmbeddableType<Orderer> class_;
	
	/**
	 * @see com.assu.study.order.command.domain.Orderer#memberId
	 **/
	public static volatile SingularAttribute<Orderer, MemberId> memberId;

}

