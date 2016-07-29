package com.forerunner.foundation.service.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forerunner.core.base.repository.user.MemberRepository;
import com.forerunner.core.base.service.BaseService;
import com.forerunner.foundation.domain.po.user.Member;
import com.forerunner.foundation.facade.user.MemberFacadeService;

@Service
@Transactional
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" }, timeout = 600000,retries = -1)
public class MemberService extends BaseService<Member,Long> implements MemberFacadeService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	public Member getAccount(String account) {
		return null;
	}

	@Override
	protected CrudRepository<Member, Long> getRepository() {
		return memberRepository;
	}	
}
