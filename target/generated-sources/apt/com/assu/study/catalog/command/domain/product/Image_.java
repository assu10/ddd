package com.assu.study.catalog.command.domain.product;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Image.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Image_ {

	public static final String PATH = "path";
	public static final String ID = "id";
	public static final String UPLOAD_TIME = "uploadTime";

	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Image#path
	 **/
	public static volatile SingularAttribute<Image, String> path;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Image#id
	 **/
	public static volatile SingularAttribute<Image, Long> id;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Image#uploadTime
	 **/
	public static volatile SingularAttribute<Image, LocalDateTime> uploadTime;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Image
	 **/
	public static volatile EntityType<Image> class_;

}

