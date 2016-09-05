package priv.zc.autosign.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.zc.autosign.model.SignInfo;
import priv.zc.autosign.model.SignInfoCriteria;

public interface SignInfoMapper {
    long countByExample(SignInfoCriteria example);

    int deleteByExample(SignInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SignInfo record);

    int insertSelective(SignInfo record);

    List<SignInfo> selectByExample(SignInfoCriteria example);

    SignInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SignInfo record, @Param("example") SignInfoCriteria example);

    int updateByExample(@Param("record") SignInfo record, @Param("example") SignInfoCriteria example);

    int updateByPrimaryKeySelective(SignInfo record);

    int updateByPrimaryKey(SignInfo record);
}