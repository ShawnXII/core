package com.forerunner.foundation.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.forerunner.core.base.repository.system.AdminMenuRepository;
import com.forerunner.core.base.service.BaseService;
import com.forerunner.foundation.domain.po.system.AdminMenu;
import com.forerunner.foundation.facade.system.AdminMenuFacadeService;

public class AdminMenuService extends BaseService<AdminMenu, Long>implements AdminMenuFacadeService {
	
	@Autowired
	private AdminMenuRepository adminMenuRepository;

	@Override
	protected CrudRepository<AdminMenu, Long> getRepository() {
		return adminMenuRepository;
	}

	@Override
	public List<AdminMenu> getCurrentMenu(Long id) {
		return null;
	}

	/**
	 * 获取菜单
	 * 
	 * @return
	 */
	public List<AdminMenu> getAdminMenuList() {
		return null;
	}
}
