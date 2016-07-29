package com.forerunner.core.base.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.forerunner.foundation.domain.po.system.AdminMenu;

public class AdminMenuRepositoryImpl {
	
	@PersistenceContext
    private EntityManager em;
	
	@SuppressWarnings("rawtypes")
	public List<AdminMenu> findAdminMenuAll(AdminMenu adminMenu){
		/*SqlTool tool=new SqlTool(AdminMenu.class);
		String table_name=tool.getTableName();
		String max_level="select max(level) from "+table_name+" where enablead=1 ";
		Query query=em.createQuery(max_level);
		List maxLevelList=query.getResultList();
		int maxLevel=0;
		if(maxLevelList!=null&&maxLevelList.size()>0){
			maxLevel=CommUtil.null2Int(maxLevelList.get(0));
		}
		StringBuilder sb=new StringBuilder();
		if(maxLevel>0){
			sb.append("select ");
			List<String> fields=tool.getFieldName();
			for(int i=0;i<maxLevel;i++){
				for(String field:fields){
					sb.append("t"+i+"."+field);
					sb.append(",");
				}
			}
		}
		return null;*/
		return null;
	}
	
	
}
