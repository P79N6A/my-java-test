package priv.zc.project.service;

import java.util.List;

import priv.zc.project.model.Config;
import priv.zc.project.model.ConfigCriteria;

public interface ConfigService {
	int deleteByPrimaryKey(Integer id);

    int insert(Config record);

    Config selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
    
    List<Config> selectByCondition(ConfigCriteria record);
}
