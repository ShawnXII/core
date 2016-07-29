package com.forerunner.foundation.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forerunner.core.base.repository.system.RoleRepository;
import com.forerunner.core.base.service.BaseService;
import com.forerunner.foundation.domain.po.system.Role;
import com.forerunner.foundation.facade.system.RoleFacadeService;

@Service
@Transactional
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" }, timeout = 600000,retries = -1)
public class RoleService extends BaseService<Role,Long> implements RoleFacadeService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	protected CrudRepository<Role, Long> getRepository() {
		return roleRepository;
	}
	
}
