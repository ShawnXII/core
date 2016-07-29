package com.forerunner.core.base.repository.system;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.forerunner.core.base.repository.BaseRepository;
import com.forerunner.foundation.domain.po.system.Config;

public interface ConfigRepository extends BaseRepository<Config,Long>,Serializable{
	
	@Query("select con from Config con where con.status=0")
	public List<Config> getConfig();
	
	
}
