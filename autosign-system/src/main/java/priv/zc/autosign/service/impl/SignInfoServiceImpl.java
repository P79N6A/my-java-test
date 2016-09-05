package priv.zc.autosign.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.zc.autosign.dao.SignInfoMapper;
import priv.zc.autosign.dao.SignLogMapper;
import priv.zc.autosign.model.SignInfo;
import priv.zc.autosign.service.SignInfoService;
import priv.zc.autosign.util.HttpUtils;
import priv.zc.autosign.vo.ResultVo;

@Service("signInfoService")
public class SignInfoServiceImpl implements SignInfoService{

	@Autowired
	private SignInfoMapper signInfoMapper;
	@Autowired
	private SignLogMapper singLogMapper;
	
	@Override
	public int insert(SignInfo signInfo) {
		return signInfoMapper.insert(signInfo);
	}

	@Override
	public List<SignInfo> select() {
		return signInfoMapper.selectByExample(null);
	}

	@Override
	public ResultVo exec(Long id) {
		SignInfo signInfo = signInfoMapper.selectByPrimaryKey(id);
		if(signInfo==null){
			return null;
		}
		String url=signInfo.getSignUrl();
		String cookie=signInfo.getCookie();
		String result=HttpUtils.get(url, cookie);
		return ResultVo.success(result);
	}

}
