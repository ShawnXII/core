package com.forerunner.core.base.repository.support;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.forerunner.core.base.entity.AbstractEntity;

/**
 * SpringData BaseRepository 实现工厂类
 * 
 * @author Administrator
 *
 * @param <R>
 * @param <M>
 * @param <ID>
 */
public class SimpleBaseRepositoryFactoryBean<R extends JpaRepository<M, ID>, M extends AbstractEntity<ID>, ID extends java.io.Serializable>
		extends JpaRepositoryFactoryBean<R, M, ID> {

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
		return new MyRepositoryFactory<M, ID>(em);
	}

	private static class MyRepositoryFactory<M extends AbstractEntity<ID>, ID extends java.io.Serializable>
			extends JpaRepositoryFactory {
		private final EntityManager em;
		
		public MyRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.em=entityManager;
		}
		
		@Override
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			 JpaEntityInformation<M, ID> entityInformation = getEntityInformation((Class<M>) metadata.getDomainType());
			return new SimpleBaseRepository<M, ID>(entityInformation, em);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return SimpleBaseRepository.class;
		}

	}
}
