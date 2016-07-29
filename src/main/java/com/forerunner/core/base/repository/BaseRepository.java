package com.forerunner.core.base.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.forerunner.core.base.entity.AbstractEntity;

/**
 * 抽象DAO层基类 提供一些简单的增删改查方法 如需更复杂的查询 请自定义sql/hql查询<br>
 * 想要使用该接口需要在spring配置文件的jpa:repositories中添加 factory-class=
 * "com.forerunner.core.base.repository.support.SimpleBaseRepositoryFactoryBean" 
 * @author Administrator
 */
@NoRepositoryBean
public interface BaseRepository<M extends AbstractEntity<ID>, ID extends java.io.Serializable>
		extends CrudRepository<M, ID>, JpaSpecificationExecutor<M>, Serializable {
		

}
