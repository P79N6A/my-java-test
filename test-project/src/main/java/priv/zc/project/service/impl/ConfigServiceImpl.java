package priv.zc.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.zc.project.dao.ConfigMapper;
import priv.zc.project.model.Config;
import priv.zc.project.model.ConfigCriteria;
import priv.zc.project.service.ConfigService;

@Service("configService")
public class ConfigServiceImpl implements ConfigService{
	@Autowired
	private ConfigMapper configMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return configMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Config record) {
		return configMapper.insert(record);
	}

	@Override
	public Config selectByPrimaryKey(Integer id) {
		return configMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Config record) {
		return configMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Config record) {
		return configMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Config> selectByCondition(ConfigCriteria record) {
		return configMapper.selectByExample(record);
	}

}
