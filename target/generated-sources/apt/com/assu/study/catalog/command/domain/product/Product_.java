package com.assu.study.catalog.command.domain.product;

import com.assu.study.catalog.command.domain.category.CategoryId;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Product_ {

	public static final String CATEGORY_IDS = "categoryIds";
	public static final String IMAGES = "images";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String DETAIL = "detail";

	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Product#categoryIds
	 **/
	public static volatile SetAttribute<Product, CategoryId> categoryIds;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Product#images
	 **/
	public static volatile ListAttribute<Product, Image> images;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Product#name
	 **/
	public static volatile SingularAttribute<Product, String> name;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Product#id
	 **/
	public static volatile SingularAttribute<Product, ProductId> id;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Product#detail
	 **/
	public static volatile SingularAttribute<Product, String> detail;
	
	/**
	 * @see com.assu.study.catalog.command.domain.product.Product
	 **/
	public static volatile EntityType<Product> class_;

}

