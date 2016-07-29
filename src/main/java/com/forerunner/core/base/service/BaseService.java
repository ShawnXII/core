package com.forerunner.core.base.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.forerunner.core.base.entity.AbstractEntity;
import com.forerunner.core.base.repository.BaseRepository;
import com.forerunner.foundation.facade.system.BaseFacadeService;

/**
 * 有事物管理
 * @author admin
 *
 * @param <M>
 * @param <ID>
 */
@Transactional
public abstract  class BaseService<M extends AbstractEntity<ID>, ID extends Serializable> implements java.io.Serializable,BaseFacadeService<M,ID>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1416856159324258914L;

	/**
	 * 日志管理
	 */
	private static final Logger logger=LoggerFactory.getLogger(BaseService.class);
	
	@Autowired
	private BaseRepository<M, ID> baseRepository;
	
	
	
	
}
