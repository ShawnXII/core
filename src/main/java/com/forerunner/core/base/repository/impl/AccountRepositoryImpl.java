package com.forerunner.core.base.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Pageable;

import com.forerunner.foundation.domain.po.user.Account;

public class AccountRepositoryImpl {
	
	@PersistenceContext
    private EntityManager em;
	
	public List<Account> findList(Pageable page,Account account){
		/*em.createQuery(criteriaQuery)*/
		String hql="from Account as acc ";
		
		return null;
	}
	
}
