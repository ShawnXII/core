package com.forerunner.core.base.repository.user;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.forerunner.core.base.repository.BaseRepository;
import com.forerunner.foundation.domain.po.user.Account;

public interface AccountRepository  extends BaseRepository<Account,String>,Serializable{
	
	@Query("select acc from Account as acc where acc.username=?1 or acc.mobile=?1 or acc.email=?1 ")
	public List<Account> getAccountByUsername(String username);
	
	public List<Account> findList(Pageable page,Account account);
}
