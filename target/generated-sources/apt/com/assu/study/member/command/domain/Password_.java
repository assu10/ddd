package com.assu.study.member.command.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Password.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Password_ {

	public static final String VALUE = "value";

	
	/**
	 * @see com.assu.study.member.command.domain.Password
	 **/
	public static volatile EmbeddableType<Password> class_;
	
	/**
	 * @see com.assu.study.member.command.domain.Password#value
	 **/
	public static volatile SingularAttribute<Password, String> value;

}

