package com.assu.study.member.command.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Member.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Member_ {

	public static final String PASSWORD = "password";
	public static final String ID = "id";

	
	/**
	 * @see com.assu.study.member.command.domain.Member#password
	 **/
	public static volatile SingularAttribute<Member, Password> password;
	
	/**
	 * @see com.assu.study.member.command.domain.Member#id
	 **/
	public static volatile SingularAttribute<Member, MemberId> id;
	
	/**
	 * @see com.assu.study.member.command.domain.Member
	 **/
	public static volatile EntityType<Member> class_;

}

