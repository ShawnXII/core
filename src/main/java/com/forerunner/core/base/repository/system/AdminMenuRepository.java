package com.forerunner.core.base.repository.system;

import java.io.Serializable;
import java.util.List;

import com.forerunner.core.base.repository.BaseRepository;
import com.forerunner.foundation.domain.po.system.AdminMenu;

public interface AdminMenuRepository extends BaseRepository<AdminMenu,Long>,Serializable{
	/**
	 * 获取有效的
	 * @param adminMenu 查询条件
	 * @return
	 */
	public List<AdminMenu> findAdminMenuAll(AdminMenu adminMenu);
}
