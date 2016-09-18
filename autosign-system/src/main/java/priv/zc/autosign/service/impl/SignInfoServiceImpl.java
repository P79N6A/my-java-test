package priv.zc.autosign.service.impl;

import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.zc.autosign.dao.SignInfoMapper;
import priv.zc.autosign.dao.SignLogMapper;
import priv.zc.autosign.model.SignInfo;
import priv.zc.autosign.model.SignInfoCriteria;
import priv.zc.autosign.model.SignLog;
import priv.zc.autosign.service.SignInfoService;
import priv.zc.autosign.util.HttpUtils;
import priv.zc.autosign.vo.ResultVo;

@Service("signInfoService")
public class SignInfoServiceImpl implements SignInfoService {
    private static Logger logger = LoggerFactory.getLogger(SignInfoServiceImpl.class);

    @Autowired
    private SignInfoMapper signInfoMapper;
    @Autowired
    private SignLogMapper signLogMapper;

    @Override
    public int insert(SignInfo signInfo) {
        signInfo.setCreateTime(new Date());
        signInfo.setUpdateTime(signInfo.getCreateTime());
        return signInfoMapper.insert(signInfo);
    }

    @Override
    public List<SignInfo> select() {
        SignInfoCriteria criteria= new SignInfoCriteria();
        criteria.setOrderByClause("id desc");
        return signInfoMapper.selectByExample(criteria);
    }

    @Override
    public ResultVo exec(Long id) {
        SignInfo signInfo = signInfoMapper.selectByPrimaryKey(id);
        if (signInfo == null) {
            return null;
        }
        logger.info("run id={}", id);
        String url = signInfo.getSignUrl();
        String cookie = signInfo.getCookie();
        String result = HttpUtils.get(url, cookie);
        logger.info("run id={} result={}", id, result);
        SignLog signLog=new SignLog();
        signLog.setInfoId(id);
        signLog.setOperationTime(new Date());
        signLog.setOriginalResult(result);
        signLogMapper.insert(signLog);
        return ResultVo.success(result);
    }

    @Override
    public int delete(Long id) {
        return signInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SignInfo select(Long id) {
        return signInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(SignInfo signInfo) {
        return signInfoMapper.updateByPrimaryKeySelective(signInfo)==1;
    }

}
