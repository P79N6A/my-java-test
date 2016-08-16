package priv.zc.project.service;

import java.util.List;

import priv.zc.project.model.SubscribeInfo;
import priv.zc.project.model.SubscribeInfoCriteria;

public interface SubscribeInfoService {
	public int deleteByPrimaryKey(Integer id);

	public int insert(SubscribeInfo record);

	public SubscribeInfo selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(SubscribeInfo record);

	public int updateByPrimaryKey(SubscribeInfo record);
    
	public List<SubscribeInfo> selectByCondition(SubscribeInfoCriteria record);
}
