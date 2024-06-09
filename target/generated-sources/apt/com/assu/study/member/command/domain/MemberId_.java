package com.assu.study.member.command.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MemberId.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class MemberId_ {

	public static final String ID = "id";

	
	/**
	 * @see com.assu.study.member.command.domain.MemberId#id
	 **/
	public static volatile SingularAttribute<MemberId, String> id;
	
	/**
	 * @see com.assu.study.member.command.domain.MemberId
	 **/
	public static volatile EmbeddableType<MemberId> class_;

}

