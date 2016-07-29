package com.forerunner.foundation.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forerunner.core.base.repository.system.ConfigRepository;
import com.forerunner.core.base.service.BaseService;
import com.forerunner.foundation.domain.po.system.Config;
import com.forerunner.foundation.facade.system.ConfigFacadeService;

@Service
@Transactional
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" }, timeout = 600000,retries = -1)
public class ConfigService extends BaseService<Config,Long> implements ConfigFacadeService{
	
	@Autowired
	private ConfigRepository configRepository;
	
	@Override
	public Config getConfig() {
		List<Config> list=configRepository.getConfig();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	protected CrudRepository<Config, Long> getRepository() {
		return configRepository;
	}

}
