package priv.zc.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.zc.project.dao.SubscribeInfoMapper;
import priv.zc.project.model.SubscribeInfo;
import priv.zc.project.model.SubscribeInfoCriteria;
import priv.zc.project.service.SubscribeInfoService;

@Service("subscribeInfoService")
public class SubscribeInfoServiceImpl implements SubscribeInfoService{

	@Autowired
	private SubscribeInfoMapper subscribeInfoMapper;
	public int deleteByPrimaryKey(Integer id) {
		return subscribeInfoMapper.deleteByPrimaryKey(id);
	}

	public int insert(SubscribeInfo record) {
		return subscribeInfoMapper.insert(record);
	}

	public SubscribeInfo selectByPrimaryKey(Integer id) {
		return subscribeInfoMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SubscribeInfo record) {
		return subscribeInfoMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SubscribeInfo record) {
		return subscribeInfoMapper.updateByPrimaryKey(record);
	}

	public List<SubscribeInfo> selectByCondition(SubscribeInfoCriteria example) {
		return subscribeInfoMapper.selectByExample(example);
	}

}
