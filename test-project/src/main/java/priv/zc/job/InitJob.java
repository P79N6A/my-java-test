package priv.zc.job;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import priv.zc.cache.CacheService;
import priv.zc.project.model.Config;
import priv.zc.project.service.ConfigService;

@Component
public class InitJob {
	@Autowired
	private CacheService cacheService;
	@Autowired
	private ConfigService configService;
	@PostConstruct
	public void init(){
		List<Config> configList = configService.selectByCondition(null);
		for(Config config:configList){
			cacheService.set(config.getConfigKey(), config.getConfigValue());
		}
	}
}
