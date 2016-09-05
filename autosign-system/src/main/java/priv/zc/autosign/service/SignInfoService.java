package priv.zc.autosign.service;

import java.util.List;

import priv.zc.autosign.model.SignInfo;
import priv.zc.autosign.vo.ResultVo;

public interface SignInfoService {
	int insert(SignInfo signInfo);
	List<SignInfo> select();
	ResultVo exec(Long id);
}
