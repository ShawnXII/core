package com.forerunner.foundation.service.system;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forerunner.core.base.repository.system.ResourceRepository;
import com.forerunner.core.base.service.BaseService;
import com.forerunner.foundation.domain.po.system.Resource;
import com.forerunner.foundation.facade.system.ResourceFacadeService;
import com.google.common.collect.Lists;

@Service
@Transactional
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" }, timeout = 600000,retries = -1)
public class ResourceService extends BaseService<Resource,String> implements ResourceFacadeService {
	
	@Autowired
	private ResourceRepository resourceRepository;
	/**
	 * 资源同步
	 */
	public void init(List<Resource> resource) {
		Iterable<Resource> able=resourceRepository.findAll();
		Iterator<Resource> ite=able.iterator();
		List<Resource> res=Lists.newArrayList();
		while(ite.hasNext()){
			Resource r1=ite.next();
			Iterator<Resource> ite1=resource.iterator();
			boolean flag=false;
			while(ite1.hasNext()){
				Resource r2=ite1.next();
				if(r1.getId().equals(r2.getId())){
					r2.setEnabled(true);
					res.add(r2);
					flag=true;
					ite1.remove();
					break;
				}
			}
			if(!flag){
				r1.setEnabled(flag);
				res.add(r1);
			}
		}
		res.addAll(resource);
		resourceRepository.save(resource);		
	}

	@Override
	protected CrudRepository<Resource, String> getRepository() {	
		return resourceRepository;
	}

}
