package com.forerunner.foundation.service.user;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forerunner.core.Exception.ServiceException;
import com.forerunner.core.base.repository.user.AccountRepository;
import com.forerunner.core.base.service.BaseService;
import com.forerunner.core.util.CommUtil;
import com.forerunner.foundation.domain.po.user.Account;
import com.forerunner.foundation.facade.user.AccountFacadeService;

@Service
@Transactional
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" }, timeout = 600000, retries = -1)
public class AccountService extends BaseService<Account, String>implements AccountFacadeService {
	
	private static final Logger log=LoggerFactory.getLogger(AccountService.class);	
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	protected CrudRepository<Account, String> getRepository() {
		return accountRepository;
	}
	
	@Override
	public Account getAccount(String username) throws ServiceException {
		List<Account> list = this.accountRepository.getAccountByUsername(username);
		Account r = null;
		if (list != null && list.size() > 0) {
			int i=0;
			for (Account acc : list) {
				if (acc.isDeleteStatus()) {
					continue;
				} else {
					i++;
					r = acc;
				}
			}
			if(i>1){
				throw new ServiceException("帐号异常");
			}
		}
		return r;
	}

	@Override
	public boolean register(String username, String password, String ip) throws ServiceException{
		log.info("===========register Account:"+username+"; Start========================");
		try {
			String salt = CommUtil.getSalt();
			Account acc = new Account();
			if (CommUtil.isMobile(username)) {
				acc.setMobile(username);
				acc.setValidateMobile(true);
				// 如果是手机 则需要通过手机验证
			} else if (CommUtil.isEmail(username)) {
				acc.setEmail(username);
				acc.setValidateEmail(false);
			} else {
				acc.setUsername(username);
			}
			acc.setIp(ip);
			acc.setCreateTime(new Date());
			acc.setEnablead(false);
			acc.setStatus(0);
			acc.setDeleteStatus(false);
			acc.setId(salt);
			String findPassword = CommUtil.encrypt(password, salt);
			acc.setPassword(findPassword);
			acc.setImageAccording("");// 系统默认的图像
			this.accountRepository.save(acc);
			log.info("===========register Account:"+username+"; Success========================");
			return true;
		} catch (Exception e) {
			log.error("register Account:"+username+" Error", e);
		}
		return false;
	}

	@Override
	public Page<Account> findList(int pageSize, int pageIndex,List<Order> orders) {
		/*Sort sort=new Sort();*/
		Sort sort=null;
		if(orders!=null){
			sort=new Sort(orders);
		}
		Pageable pageable=new PageRequest(pageIndex,pageSize,sort);
		return accountRepository.findAll(pageable);
	}

	@Override
	public Page<Account> findList(int pageSize, int pageIndex) {
		return this.findList(pageSize, pageIndex,null);
	}
	
}
