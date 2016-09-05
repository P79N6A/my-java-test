package priv.zc.autosign.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.zc.autosign.model.SignLog;
import priv.zc.autosign.model.SignLogCriteria;

public interface SignLogMapper {
    long countByExample(SignLogCriteria example);

    int deleteByExample(SignLogCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SignLog record);

    int insertSelective(SignLog record);

    List<SignLog> selectByExampleWithBLOBs(SignLogCriteria example);

    List<SignLog> selectByExample(SignLogCriteria example);

    SignLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SignLog record, @Param("example") SignLogCriteria example);

    int updateByExampleWithBLOBs(@Param("record") SignLog record, @Param("example") SignLogCriteria example);

    int updateByExample(@Param("record") SignLog record, @Param("example") SignLogCriteria example);

    int updateByPrimaryKeySelective(SignLog record);

    int updateByPrimaryKeyWithBLOBs(SignLog record);

    int updateByPrimaryKey(SignLog record);
}