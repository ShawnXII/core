package com.forerunner.core.base.repository.support;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.forerunner.core.base.entity.AbstractEntity;
import com.forerunner.core.base.repository.BaseRepository;

public class SimpleBaseRepository<M extends AbstractEntity<ID>, ID extends java.io.Serializable>
		extends SimpleJpaRepository<M, ID>implements BaseRepository<M, ID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4732754561051046915L;
	 private final  EntityManager em;
	 
	 private final JpaEntityInformation<M,ID> infomation;

	public SimpleBaseRepository(JpaEntityInformation<M,ID> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em=em;
		this.infomation=domainClass;
	}
	
	
}
